package com.tencent.qqnt.qbasealbum.base.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.inject.g;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PageType;
import com.tencent.qqnt.qbasealbum.model.TabType;
import com.tencent.qqnt.qbasealbum.preview.fragment.QAlbumPreviewChildFragment;
import com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J(\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J \u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/base/model/UniversalItemClickListener;", "Lcom/tencent/qqnt/qbasealbum/base/model/a;", "Landroid/view/View;", "v", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, "", "layoutPosition", "", "b", "itemInfo", "Lcom/tencent/qqnt/qbasealbum/model/PageType;", "pageType", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "selectedMediaViewModel", "a", "toAddedMedia", "d", "c", "toRemovedMedia", "e", "", "toastMsg", "f", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class UniversalItemClickListener implements com.tencent.qqnt.qbasealbum.base.model.a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f361045a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34561);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[TabType.values().length];
            try {
                iArr[TabType.TAB_MEDIA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TabType.TAB_ALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TabType.TAB_IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TabType.TAB_VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f361045a = iArr;
        }
    }

    public UniversalItemClickListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.base.model.a
    public int a(@NotNull View v3, @NotNull LocalMediaInfo itemInfo, @NotNull PageType pageType, @NotNull SelectedMediaViewModel selectedMediaViewModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, v3, itemInfo, pageType, selectedMediaViewModel)).intValue();
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
        if (itemInfo.getSelectStatus() == 1) {
            e(itemInfo, selectedMediaViewModel);
        } else if (selectedMediaViewModel.W1()) {
            d(v3, itemInfo, selectedMediaViewModel);
        } else {
            c(v3, itemInfo, selectedMediaViewModel);
        }
        return itemInfo.getSelectStatus();
    }

    @Override // com.tencent.qqnt.qbasealbum.base.model.a
    public void b(@NotNull final View v3, @NotNull final List<LocalMediaInfo> media, final int layoutPosition) {
        Object orNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, v3, media, Integer.valueOf(layoutPosition));
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(media, "media");
        orNull = CollectionsKt___CollectionsKt.getOrNull(media, layoutPosition);
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) orNull;
        if (localMediaInfo != null) {
            com.tencent.qqnt.qbasealbum.filter.b bVar = com.tencent.qqnt.qbasealbum.filter.b.f361200a;
            Context context = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "v.context");
            bVar.b(context, com.tencent.qqnt.qbasealbum.ktx.b.h(localMediaInfo), new Function0<Unit>(v3, media, layoutPosition) { // from class: com.tencent.qqnt.qbasealbum.base.model.UniversalItemClickListener$onItemClick$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $layoutPosition;
                final /* synthetic */ List<LocalMediaInfo> $media;
                final /* synthetic */ View $v;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$v = v3;
                    this.$media = media;
                    this.$layoutPosition = layoutPosition;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, v3, media, Integer.valueOf(layoutPosition));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    List listOf;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    RFWLayerLaunchUtil rFWLayerLaunchUtil = RFWLayerLaunchUtil.INSTANCE;
                    Context context2 = this.$v.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "v.context");
                    QAlbumBaseMainFragment<?> l3 = QAlbumPickerContext.f361201a.l();
                    Intrinsics.checkNotNull(l3);
                    FragmentManager childFragmentManager = l3.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "QAlbumPickerContext.getS\u2026()!!.childFragmentManager");
                    View view = this.$v;
                    Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
                    ImageView imageView = (ImageView) ((ViewGroup) view).findViewById(R.id.f24990_m);
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(com.tencent.qqnt.qbasealbum.ktx.b.u(this.$media.get(this.$layoutPosition)));
                    e.b(rFWLayerLaunchUtil, context2, childFragmentManager, imageView, listOf, 0, QAlbumPreviewChildFragment.class, null, R.id.cks);
                }
            });
        }
    }

    protected void c(@NotNull View v3, @NotNull LocalMediaInfo toAddedMedia, @NotNull SelectedMediaViewModel selectedMediaViewModel) {
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, v3, toAddedMedia, selectedMediaViewModel);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(toAddedMedia, "toAddedMedia");
        Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
        String string2 = v3.getContext().getResources().getString(R.string.f17712334, Integer.valueOf(selectedMediaViewModel.R1()));
        Intrinsics.checkNotNullExpressionValue(string2, "v.context.resources.getS\u2026SelectMediaSize\n        )");
        int i3 = a.f361045a[QAlbumPickerContext.f361201a.e().e().ordinal()];
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                if (i3 == 4) {
                    string = v3.getContext().getResources().getString(R.string.f17715337);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                string = v3.getContext().getResources().getString(R.string.f17714336);
            }
        } else {
            string = v3.getContext().getResources().getString(R.string.f17713335);
        }
        Intrinsics.checkNotNullExpressionValue(string, "when (QAlbumPickerContex\u2026ist_type_video)\n        }");
        f(v3, string2 + string);
    }

    protected void d(@NotNull View v3, @NotNull final LocalMediaInfo toAddedMedia, @NotNull final SelectedMediaViewModel selectedMediaViewModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, v3, toAddedMedia, selectedMediaViewModel);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(toAddedMedia, "toAddedMedia");
        Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
        int h16 = com.tencent.qqnt.qbasealbum.ktx.b.h(toAddedMedia);
        com.tencent.qqnt.qbasealbum.filter.b bVar = com.tencent.qqnt.qbasealbum.filter.b.f361200a;
        Context context = v3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "v.context");
        bVar.b(context, h16, new Function0<Unit>(toAddedMedia) { // from class: com.tencent.qqnt.qbasealbum.base.model.UniversalItemClickListener$onItemSelected$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ LocalMediaInfo $toAddedMedia;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$toAddedMedia = toAddedMedia;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectedMediaViewModel.this, (Object) toAddedMedia);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    SelectedMediaViewModel.O1(SelectedMediaViewModel.this, this.$toAddedMedia, 0, 2, null);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    protected void e(@NotNull LocalMediaInfo toRemovedMedia, @NotNull SelectedMediaViewModel selectedMediaViewModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) toRemovedMedia, (Object) selectedMediaViewModel);
            return;
        }
        Intrinsics.checkNotNullParameter(toRemovedMedia, "toRemovedMedia");
        Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
        selectedMediaViewModel.Z1(com.tencent.qqnt.qbasealbum.ktx.b.e(toRemovedMedia), toRemovedMedia);
    }

    protected void f(@NotNull View v3, @NotNull String toastMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) v3, (Object) toastMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(toastMsg, "toastMsg");
        if (!FastClickUtils.isFastDoubleClick("key_show_toast_interval", 2000L)) {
            g gVar = g.f361234b;
            Context context = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "v.context");
            gVar.showToast(context, toastMsg, 0);
        }
    }
}

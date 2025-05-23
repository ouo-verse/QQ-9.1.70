package com.tencent.mobileqq.flock.publish.part;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.IdRes;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.flock.publish.part.FlockPublishImageGalleryPart;
import com.tencent.mobileqq.flock.widget.j;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQZonePadApi;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 =2\u00020\u0001:\u0003>?@B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\u000f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\tH\u0016J\"\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u00060%R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001d\u00104\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010\u001e\u001a\u0004\b2\u00103R#\u0010:\u001a\n 6*\u0004\u0018\u000105058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u0010\u001e\u001a\u0004\b8\u00109\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/part/FlockPublishImageGalleryPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/flock/publish/viewmodel/m;", "action", "", "O9", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "L9", "Landroid/view/View;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "childResId", "", NodeProps.VISIBLE, "P9", "M9", "K9", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/flock/publish/viewmodel/b;", "d", "Lkotlin/Lazy;", "J9", "()Lcom/tencent/mobileqq/flock/publish/viewmodel/b;", "viewModel", "e", "Landroidx/recyclerview/widget/RecyclerView;", "selectedMediaRV", "Lcom/tencent/mobileqq/flock/publish/part/FlockPublishImageGalleryPart$b;", "f", "Lcom/tencent/mobileqq/flock/publish/part/FlockPublishImageGalleryPart$b;", "galleryAdapter", "Landroidx/recyclerview/widget/GridLayoutManager;", tl.h.F, "Landroidx/recyclerview/widget/GridLayoutManager;", "galleryLayoutManager", "i", "I", "galleryItemSize", "Lcom/tencent/mobileqq/flock/publish/part/FlockPublishKeyboardPart;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "H9", "()Lcom/tencent/mobileqq/flock/publish/part/FlockPublishKeyboardPart;", "keyboardPart", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "I9", "()Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "<init>", "()V", "D", "a", "b", "ImageGalleryViewHolder", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockPublishImageGalleryPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int E;
    private static final int F;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy qqPermission;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView selectedMediaRV;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b galleryAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GridLayoutManager galleryLayoutManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int galleryItemSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy keyboardPart;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\n\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u001c\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\n \u000b*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/part/FlockPublishImageGalleryPart$ImageGalleryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "", "o", "", "deletable", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "Landroid/view/View;", "kotlin.jvm.PlatformType", "E", "Landroid/view/View;", "galleryAddBtn", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "galleryImageView", "G", "ivRemove", "itemView", "<init>", "(Lcom/tencent/mobileqq/flock/publish/part/FlockPublishImageGalleryPart;Landroid/view/View;)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public final class ImageGalleryViewHolder extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        private final View galleryAddBtn;

        /* renamed from: F, reason: from kotlin metadata */
        private final ImageView galleryImageView;

        /* renamed from: G, reason: from kotlin metadata */
        private final View ivRemove;
        final /* synthetic */ FlockPublishImageGalleryPart H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImageGalleryViewHolder(@NotNull FlockPublishImageGalleryPart flockPublishImageGalleryPart, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.H = flockPublishImageGalleryPart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) flockPublishImageGalleryPart, (Object) itemView);
                return;
            }
            this.galleryAddBtn = itemView.findViewById(R.id.vh9);
            this.galleryImageView = (ImageView) itemView.findViewById(R.id.vhc);
            this.ivRemove = itemView.findViewById(R.id.f165964y84);
        }

        private final void o(final LocalMediaInfo mediaInfo) {
            boolean z16;
            String str = mediaInfo.path;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                this.galleryAddBtn.setVisibility(0);
                View galleryAddBtn = this.galleryAddBtn;
                Intrinsics.checkNotNullExpressionValue(galleryAddBtn, "galleryAddBtn");
                final FlockPublishImageGalleryPart flockPublishImageGalleryPart = this.H;
                com.tencent.mobileqq.flock.ktx.i.d(galleryAddBtn, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishImageGalleryPart$ImageGalleryViewHolder$setImage$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockPublishImageGalleryPart.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View it) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        } else {
                            Intrinsics.checkNotNullParameter(it, "it");
                            FlockPublishImageGalleryPart.this.M9();
                        }
                    }
                }, 1, null);
                this.galleryImageView.setVisibility(4);
                this.galleryImageView.setOnClickListener(null);
                return;
            }
            this.galleryAddBtn.setVisibility(4);
            this.galleryAddBtn.setOnClickListener(null);
            this.galleryImageView.setVisibility(0);
            ImageView imageView = this.galleryImageView;
            final FlockPublishImageGalleryPart flockPublishImageGalleryPart2 = this.H;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.publish.part.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FlockPublishImageGalleryPart.ImageGalleryViewHolder.p(FlockPublishImageGalleryPart.this, this, mediaInfo, view);
                }
            });
            com.tencent.mobileqq.flock.picloader.a.a().c(Option.obtain().setUrl(mediaInfo.path).setTargetView(this.galleryImageView).setRequestWidth(this.H.galleryItemSize).setRequestHeight(this.H.galleryItemSize).setLoadingDrawableId(R.drawable.trans).setFailedDrawableId(R.drawable.trans));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(FlockPublishImageGalleryPart this$0, ImageGalleryViewHolder this$1, LocalMediaInfo mediaInfo, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
            com.tencent.mobileqq.flock.publish.viewmodel.b J9 = this$0.J9();
            Activity activity = this$0.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            ImageView galleryImageView = this$1.galleryImageView;
            Intrinsics.checkNotNullExpressionValue(galleryImageView, "galleryImageView");
            J9.b2(activity, galleryImageView, mediaInfo, this$1.getLayoutPosition());
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
        
            if (r2 == false) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void q(LocalMediaInfo mediaInfo, boolean deletable) {
            int i3;
            boolean z16;
            View view = this.ivRemove;
            if (deletable) {
                String str = mediaInfo.path;
                i3 = 0;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
            }
            i3 = 4;
            view.setVisibility(i3);
            View view2 = this.ivRemove;
            final FlockPublishImageGalleryPart flockPublishImageGalleryPart = this.H;
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.publish.part.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    FlockPublishImageGalleryPart.ImageGalleryViewHolder.r(FlockPublishImageGalleryPart.this, this, view3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(FlockPublishImageGalleryPart this$0, ImageGalleryViewHolder this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.J9().g2(this$1.getLayoutPosition());
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void n(@NotNull LocalMediaInfo mediaInfo, boolean deletable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, mediaInfo, Boolean.valueOf(deletable));
                return;
            }
            Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
            o(mediaInfo);
            q(mediaInfo, deletable);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/part/FlockPublishImageGalleryPart$a;", "", "", "GALLERY_MARGIN", "I", "GALLERY_SPACE", "SPAN_COUNT", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.publish.part.FlockPublishImageGalleryPart$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u001c\u0010\b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016R(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/part/FlockPublishImageGalleryPart$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/flock/publish/part/FlockPublishImageGalleryPart$ImageGalleryViewHolder;", "Lcom/tencent/mobileqq/flock/publish/part/FlockPublishImageGalleryPart;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "", "i0", "getItemCount", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "getSelectedMedia", "()Ljava/util/List;", "l0", "(Ljava/util/List;)V", "selectedMedia", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "getDeletable", "()Z", "k0", "(Z)V", "deletable", "<init>", "(Lcom/tencent/mobileqq/flock/publish/part/FlockPublishImageGalleryPart;)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public final class b extends RecyclerView.Adapter<ImageGalleryViewHolder> {
        static IPatchRedirector $redirector_;

        /* renamed from: C, reason: from kotlin metadata */
        private boolean deletable;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<? extends LocalMediaInfo> selectedMedia;

        public b() {
            List<? extends LocalMediaInfo> emptyList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                this.selectedMedia = emptyList;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockPublishImageGalleryPart.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return this.selectedMedia.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull ImageGalleryViewHolder holder, int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) holder, position);
                return;
            }
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.itemView.setLayoutParams(new ViewGroup.LayoutParams(FlockPublishImageGalleryPart.this.galleryItemSize, FlockPublishImageGalleryPart.this.galleryItemSize));
            holder.n(this.selectedMedia.get(position), this.deletable);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public ImageGalleryViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (ImageGalleryViewHolder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) parent, viewType);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.e8o, parent, false);
            itemView.setLayoutParams(new ViewGroup.LayoutParams(FlockPublishImageGalleryPart.this.galleryItemSize, FlockPublishImageGalleryPart.this.galleryItemSize));
            FlockPublishImageGalleryPart flockPublishImageGalleryPart = FlockPublishImageGalleryPart.this;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new ImageGalleryViewHolder(flockPublishImageGalleryPart, itemView);
        }

        public final void k0(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
            } else {
                this.deletable = z16;
            }
        }

        public final void l0(@NotNull List<? extends LocalMediaInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            } else {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.selectedMedia = list;
            }
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/flock/publish/part/FlockPublishImageGalleryPart$c", "Lcom/tencent/mobileqq/flock/widget/j$a;", "", "getSize", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "d", "fromPosition", "toPosition", "", "onItemMoved", "position", "c", "a", "isInside", "b", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements j.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockPublishImageGalleryPart.this);
            }
        }

        @Override // com.tencent.mobileqq.flock.widget.j.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                FlockPublishKeyboardPart H9 = FlockPublishImageGalleryPart.this.H9();
                if (H9 != null) {
                    H9.E9();
                }
                FlockPublishImageGalleryPart.this.galleryAdapter.k0(true);
                GridLayoutManager gridLayoutManager = FlockPublishImageGalleryPart.this.galleryLayoutManager;
                if (gridLayoutManager != null) {
                    FlockPublishImageGalleryPart flockPublishImageGalleryPart = FlockPublishImageGalleryPart.this;
                    int R1 = flockPublishImageGalleryPart.J9().R1();
                    for (int i3 = 0; i3 < R1; i3++) {
                        flockPublishImageGalleryPart.P9(gridLayoutManager.getChildAt(i3), R.id.f165964y84, true);
                    }
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this);
        }

        @Override // com.tencent.mobileqq.flock.widget.j.a
        public void b(boolean isInside) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, isInside);
            }
        }

        @Override // com.tencent.mobileqq.flock.widget.j.a
        public void c(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, position);
            }
        }

        @Override // com.tencent.mobileqq.flock.widget.j.a
        public boolean d(@NotNull RecyclerView.ViewHolder viewHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            return !FlockPublishImageGalleryPart.this.J9().Z1(viewHolder.getLayoutPosition());
        }

        @Override // com.tencent.mobileqq.flock.widget.j.a
        public int getSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return FlockPublishImageGalleryPart.this.J9().R1();
        }

        @Override // com.tencent.mobileqq.flock.widget.j.a
        public void onItemMoved(int fromPosition, int toPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(fromPosition), Integer.valueOf(toPosition));
            } else {
                FlockPublishImageGalleryPart.this.J9().d2(fromPosition, toPosition);
            }
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/flock/publish/part/FlockPublishImageGalleryPart$d", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "", "onDenied", "onAllGranted", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockPublishImageGalleryPart.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            super.onAllGranted();
            com.tencent.mobileqq.flock.publish.viewmodel.b J9 = FlockPublishImageGalleryPart.this.J9();
            Activity activity = FlockPublishImageGalleryPart.this.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            J9.c2(activity);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) permissions, (Object) results);
            } else {
                super.onDenied(permissions, results);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48341);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        E = com.tencent.mobileqq.flock.ktx.i.b(32);
        F = com.tencent.mobileqq.flock.ktx.i.a(6.5f);
    }

    public FlockPublishImageGalleryPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.publish.viewmodel.b>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishImageGalleryPart$viewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishImageGalleryPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.mobileqq.flock.publish.viewmodel.b invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.mobileqq.flock.publish.viewmodel.b) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FlockPublishImageGalleryPart flockPublishImageGalleryPart = FlockPublishImageGalleryPart.this;
                    Intent intent = flockPublishImageGalleryPart.getActivity().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
                    return com.tencent.mobileqq.flock.publish.a.b(flockPublishImageGalleryPart, intent);
                }
            });
            this.viewModel = lazy;
            this.galleryAdapter = new b();
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FlockPublishKeyboardPart>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishImageGalleryPart$keyboardPart$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishImageGalleryPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final FlockPublishKeyboardPart invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? com.tencent.mobileqq.flock.publish.a.c(FlockPublishImageGalleryPart.this) : (FlockPublishKeyboardPart) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.keyboardPart = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<QQPermission>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishImageGalleryPart$qqPermission$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishImageGalleryPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final QQPermission invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? QQPermissionFactory.getQQPermission(FlockPublishImageGalleryPart.this.getHostFragment(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_FLOCK, QQPermissionConstants.Business.SCENE.FLOCK_MEDIA_PICKER)) : (QQPermission) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.qqPermission = lazy3;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FlockPublishKeyboardPart H9() {
        return (FlockPublishKeyboardPart) this.keyboardPart.getValue();
    }

    private final QQPermission I9() {
        return (QQPermission) this.qqPermission.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.flock.publish.viewmodel.b J9() {
        return (com.tencent.mobileqq.flock.publish.viewmodel.b) this.viewModel.getValue();
    }

    private final boolean K9() {
        if (I9().hasPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && I9().hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            return true;
        }
        return false;
    }

    private final void L9(RecyclerView recyclerView) {
        com.tencent.mobileqq.flock.widget.j jVar = new com.tencent.mobileqq.flock.widget.j();
        jVar.b(new c());
        new ItemTouchHelper(jVar).attachToRecyclerView(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9() {
        if (K9()) {
            com.tencent.mobileqq.flock.publish.viewmodel.b J9 = J9();
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            J9.c2(activity);
            return;
        }
        I9().requestPermissions(new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(com.tencent.mobileqq.flock.publish.viewmodel.m action) {
        if (action instanceof com.tencent.mobileqq.flock.publish.viewmodel.l) {
            com.tencent.mobileqq.flock.publish.viewmodel.l lVar = (com.tencent.mobileqq.flock.publish.viewmodel.l) action;
            this.galleryAdapter.notifyItemMoved(lVar.a(), lVar.b());
            RecyclerView recyclerView = this.selectedMediaRV;
            if (recyclerView != null) {
                recyclerView.invalidateItemDecorations();
                return;
            }
            return;
        }
        if (action instanceof com.tencent.mobileqq.flock.publish.viewmodel.j) {
            this.galleryAdapter.notifyItemChanged(((com.tencent.mobileqq.flock.publish.viewmodel.j) action).a());
            return;
        }
        if (action instanceof com.tencent.mobileqq.flock.publish.viewmodel.k) {
            this.galleryAdapter.notifyItemRemoved(((com.tencent.mobileqq.flock.publish.viewmodel.k) action).a());
            RecyclerView recyclerView2 = this.selectedMediaRV;
            if (recyclerView2 != null) {
                recyclerView2.invalidateItemDecorations();
                return;
            }
            return;
        }
        this.galleryAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(View parent, @IdRes int childResId, boolean visible) {
        View view;
        int i3;
        if (parent != null) {
            view = parent.findViewById(childResId);
        } else {
            view = null;
        }
        if (view != null) {
            if (visible) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            view.setVisibility(i3);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == -1) {
            J9().f2(data);
        } else if (requestCode == 101) {
            J9().e2(resultCode, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        this.galleryItemSize = ((((IQZonePadApi) QRoute.api(IQZonePadApi.class)).getScreenWidth(getContext()) - (E * 2)) - (F * 2)) / 3;
        this.galleryAdapter.notifyDataSetChanged();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        int screenWidth = ((IQZonePadApi) QRoute.api(IQZonePadApi.class)).getScreenWidth(getContext()) - (E * 2);
        int i3 = F;
        this.galleryItemSize = (screenWidth - (i3 * 2)) / 3;
        this.galleryLayoutManager = new GridLayoutManager(getContext(), 3);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.xif);
        recyclerView.setLayoutManager(this.galleryLayoutManager);
        recyclerView.setAdapter(this.galleryAdapter);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "this");
        L9(recyclerView);
        recyclerView.addItemDecoration(new com.tencent.mobileqq.flock.widget.e(3, i3, false));
        this.selectedMediaRV = recyclerView;
        com.tencent.mobileqq.flock.publish.viewmodel.b J9 = J9();
        this.galleryAdapter.l0(J9.getSelectedMedia());
        this.galleryAdapter.notifyDataSetChanged();
        LiveData<com.tencent.mobileqq.flock.publish.viewmodel.m> T1 = J9.T1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.flock.publish.viewmodel.m, Unit> function1 = new Function1<com.tencent.mobileqq.flock.publish.viewmodel.m, Unit>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishImageGalleryPart$onInitView$2$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishImageGalleryPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.flock.publish.viewmodel.m mVar) {
                invoke2(mVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.flock.publish.viewmodel.m it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                FlockPublishImageGalleryPart flockPublishImageGalleryPart = FlockPublishImageGalleryPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                flockPublishImageGalleryPart.O9(it);
            }
        };
        T1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.flock.publish.part.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockPublishImageGalleryPart.N9(Function1.this, obj);
            }
        });
    }
}

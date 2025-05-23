package com.tencent.mobileqq.troop.troopcard.reborn.part;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardCoverPart;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopAvatarCoverEditViewModel;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel;
import com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper;
import com.tencent.mobileqq.utils.ep;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t*\u00019\u0018\u0000 F2\u00020\u0001:\u0002GHB\u000f\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\"\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\tH\u0002J\u001c\u0010\u0017\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00104\u001a\u000601R\u00020\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u0011058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardCoverPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "M9", "N9", "", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/f;", "imageList", "O9", "", "index", "K9", "Landroid/content/Context;", "context", "", "isFirst", "rightMargin", "Landroid/view/View;", "J9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartDestroy", "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "getAppInterface", "()Lcom/tencent/common/app/AppInterface;", "appInterface", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", "e", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", "troopBasicInfoViewModel", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopAvatarCoverEditViewModel;", "f", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopAvatarCoverEditViewModel;", "avatarCoverEditViewModel", "Landroidx/viewpager2/widget/ViewPager2;", tl.h.F, "Landroidx/viewpager2/widget/ViewPager2;", "coverViewPager", "Landroidx/appcompat/widget/LinearLayoutCompat;", "i", "Landroidx/appcompat/widget/LinearLayoutCompat;", "coverViewPagerIndicatorLayout", "Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardCoverPart$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardCoverPart$a;", "adapter", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "indicatorDotList", "com/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardCoverPart$autoScrollRunnable$1", "D", "Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardCoverPart$autoScrollRunnable$1;", "autoScrollRunnable", "E", "Z", "isAutoScrolling", "Lcom/tencent/mobileqq/utils/ep;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/utils/ep;", "clickTrigger", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "G", "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopInfoCardCoverPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<View> indicatorDotList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final TroopInfoCardCoverPart$autoScrollRunnable$1 autoScrollRunnable;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isAutoScrolling;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ep clickTrigger;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppInterface appInterface;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TroopBasicInfoViewModel troopBasicInfoViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TroopAvatarCoverEditViewModel avatarCoverEditViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewPager2 coverViewPager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LinearLayoutCompat coverViewPagerIndicatorLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private a adapter;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ \u0010\u0012\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\fH\u0016J \u0010\u0015\u001a\u00020\n2\u000e\u0010\u0013\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardCoverPart$a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardCoverPart$a$a;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardCoverPart;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/f;", "coverUIModel", "Lcom/tencent/image/URLDrawable;", "k0", "", "imageList", "", "setDataList", "", com.tencent.luggage.wxa.c8.c.G, "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "n0", "holder", "position", "l0", "getItemCount", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "<init>", "(Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardCoverPart;)V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public final class a extends RecyclerView.Adapter<C8791a> {
        static IPatchRedirector $redirector_;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f> imageList;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardCoverPart$a$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "imageView", "<init>", "(Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardCoverPart$a;Landroid/widget/ImageView;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardCoverPart$a$a, reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        public final class C8791a extends RecyclerView.ViewHolder {
            static IPatchRedirector $redirector_;

            /* renamed from: E, reason: from kotlin metadata */
            @NotNull
            private final ImageView imageView;
            final /* synthetic */ a F;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C8791a(@NotNull a aVar, ImageView imageView) {
                super(imageView);
                Intrinsics.checkNotNullParameter(imageView, "imageView");
                this.F = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) imageView);
                } else {
                    this.imageView = imageView;
                }
            }

            @NotNull
            public final ImageView l() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (ImageView) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.imageView;
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardCoverPart$a$b", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapConfirmed", "onDown", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes19.dex */
        public static final class b extends GestureDetector.SimpleOnGestureListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ TroopInfoCardCoverPart f299556d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f299557e;

            b(TroopInfoCardCoverPart troopInfoCardCoverPart, int i3) {
                this.f299556d = troopInfoCardCoverPart;
                this.f299557e = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopInfoCardCoverPart, i3);
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(@Nullable MotionEvent e16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    this.f299556d.N9();
                    return true;
                }
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) e16)).booleanValue();
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(@Nullable MotionEvent e16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    this.f299556d.K9(this.f299557e);
                    return super.onSingleTapConfirmed(e16);
                }
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) e16)).booleanValue();
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardCoverPart.this);
            } else {
                this.imageList = new ArrayList();
            }
        }

        private final URLDrawable k0(com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f coverUIModel) {
            URL uRL4TroopPhoto = ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getURL4TroopPhoto(coverUIModel.a());
            String str = null;
            if (uRL4TroopPhoto == null) {
                return null;
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mRequestWidth = -1;
            obtain.mRequestHeight = -1;
            Rect rect = new Rect();
            ITroopPhotoUtilsApi iTroopPhotoUtilsApi = (ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class);
            com.tencent.mobileqq.troop.avatar.a a16 = com.tencent.mobileqq.troop.troopcard.reborn.uimodel.g.a(coverUIModel);
            if (a16 != null) {
                str = a16.f294536h;
            }
            if (str == null) {
                str = "";
            }
            iTroopPhotoUtilsApi.getClipRect(rect, str);
            URLDrawable drawable = URLDrawable.getDrawable(uRL4TroopPhoto, obtain);
            drawable.setTag(((ITroopCardApi) QRoute.api(ITroopCardApi.class)).buildCustomClipDecoderParams(rect.left, rect.top, rect.width(), rect.height(), ImmersiveUtils.getScreenWidth(), (ImmersiveUtils.getScreenWidth() * com.tencent.mobileqq.utils.am.a(196.0f)) / com.tencent.mobileqq.utils.am.a(375.0f)));
            Object _custom_clip_decoder = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).get_CUSTOM_CLIP_DECODER();
            Intrinsics.checkNotNull(_custom_clip_decoder, "null cannot be cast to non-null type com.tencent.image.DownloadParams.DecodeHandler");
            drawable.setDecodeHandler((DownloadParams.DecodeHandler) _custom_clip_decoder);
            return drawable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean m0(TroopInfoCardCoverPart this$0, GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(gestureDetector, "$gestureDetector");
            if (motionEvent.getAction() == 1) {
                this$0.M9();
            }
            return gestureDetector.onTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            if (this.imageList.size() <= 1) {
                return this.imageList.size();
            }
            return this.imageList.size() + 2;
        }

        public final int j0(int pos) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, pos)).intValue();
            }
            if (getNUM_BACKGOURND_ICON() <= 1) {
                return pos;
            }
            return pos % this.imageList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull C8791a holder, int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) holder, position);
                return;
            }
            Intrinsics.checkNotNullParameter(holder, "holder");
            int j06 = j0(position);
            holder.l().setImageDrawable(k0(this.imageList.get(j06)));
            final GestureDetector gestureDetector = new GestureDetector(TroopInfoCardCoverPart.this.getPartRootView().getContext(), new b(TroopInfoCardCoverPart.this, j06));
            ImageView l3 = holder.l();
            final TroopInfoCardCoverPart troopInfoCardCoverPart = TroopInfoCardCoverPart.this;
            l3.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.am
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean m06;
                    m06 = TroopInfoCardCoverPart.a.m0(TroopInfoCardCoverPart.this, gestureDetector, view, motionEvent);
                    return m06;
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: n0, reason: merged with bridge method [inline-methods] */
        public C8791a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (C8791a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent, viewType);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            ImageView imageView = new ImageView(parent.getContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return new C8791a(this, imageView);
        }

        public final void setDataList(@NotNull List<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f> imageList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) imageList);
                return;
            }
            Intrinsics.checkNotNullParameter(imageList, "imageList");
            this.imageList.clear();
            this.imageList.addAll(imageList);
            notifyDataSetChanged();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardCoverPart$b;", "", "", "SCROLL_INTERVAL", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardCoverPart$b, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardCoverPart$c", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "state", "onPageScrollStateChanged", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends ViewPager2.OnPageChangeCallback {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardCoverPart.this);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, state);
                return;
            }
            super.onPageScrollStateChanged(state);
            a aVar = TroopInfoCardCoverPart.this.adapter;
            ViewPager2 viewPager2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                aVar = null;
            }
            if (aVar.getNUM_BACKGOURND_ICON() <= 1) {
                return;
            }
            if (state == 0) {
                ViewPager2 viewPager22 = TroopInfoCardCoverPart.this.coverViewPager;
                if (viewPager22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
                    viewPager22 = null;
                }
                int currentItem = viewPager22.getCurrentItem();
                a aVar2 = TroopInfoCardCoverPart.this.adapter;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    aVar2 = null;
                }
                int num_backgournd_icon = aVar2.getNUM_BACKGOURND_ICON() - 1;
                if (currentItem == 0) {
                    ViewPager2 viewPager23 = TroopInfoCardCoverPart.this.coverViewPager;
                    if (viewPager23 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
                    } else {
                        viewPager2 = viewPager23;
                    }
                    viewPager2.setCurrentItem(num_backgournd_icon - 1, false);
                } else if (currentItem == num_backgournd_icon) {
                    ViewPager2 viewPager24 = TroopInfoCardCoverPart.this.coverViewPager;
                    if (viewPager24 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
                    } else {
                        viewPager2 = viewPager24;
                    }
                    viewPager2.setCurrentItem(1, false);
                }
                if (!TroopInfoCardCoverPart.this.isAutoScrolling) {
                    TroopInfoCardCoverPart.this.M9();
                    return;
                }
                return;
            }
            if (state == 1) {
                TroopInfoCardCoverPart.this.N9();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, position);
                return;
            }
            super.onPageSelected(position);
            a aVar = TroopInfoCardCoverPart.this.adapter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                aVar = null;
            }
            int j06 = aVar.j0(position);
            int i3 = 0;
            for (Object obj : TroopInfoCardCoverPart.this.indicatorDotList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                View view = (View) obj;
                if (i3 == j06) {
                    view.setBackgroundResource(R.drawable.kyy);
                } else {
                    view.setBackgroundResource(R.drawable.kyx);
                }
                i3 = i16;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57186);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardCoverPart$autoScrollRunnable$1] */
    public TroopInfoCardCoverPart(@NotNull AppInterface appInterface) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.appInterface = appInterface;
        this.indicatorDotList = new ArrayList();
        this.autoScrollRunnable = new Runnable() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardCoverPart$autoScrollRunnable$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopInfoCardCoverPart.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    TroopInfoCardCoverPart.a aVar = TroopInfoCardCoverPart.this.adapter;
                    ViewPager2 viewPager2 = null;
                    if (aVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        aVar = null;
                    }
                    if (aVar.getNUM_BACKGOURND_ICON() > 1) {
                        ViewPager2 viewPager22 = TroopInfoCardCoverPart.this.coverViewPager;
                        if (viewPager22 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
                            viewPager22 = null;
                        }
                        int currentItem = viewPager22.getCurrentItem() + 1;
                        TroopInfoCardCoverPart.a aVar2 = TroopInfoCardCoverPart.this.adapter;
                        if (aVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                            aVar2 = null;
                        }
                        int num_backgournd_icon = currentItem % aVar2.getNUM_BACKGOURND_ICON();
                        ViewPager2 viewPager23 = TroopInfoCardCoverPart.this.coverViewPager;
                        if (viewPager23 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
                            viewPager23 = null;
                        }
                        viewPager23.setCurrentItem(num_backgournd_icon, true);
                        ViewPager2 viewPager24 = TroopInfoCardCoverPart.this.coverViewPager;
                        if (viewPager24 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
                        } else {
                            viewPager2 = viewPager24;
                        }
                        viewPager2.postDelayed(this, 4000L);
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        };
        this.clickTrigger = new ep(0L, 1, null);
    }

    private final View J9(Context context, boolean isFirst, int rightMargin) {
        int i3;
        LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(com.tencent.mobileqq.utils.am.a(4.0f), com.tencent.mobileqq.utils.am.a(4.0f));
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = rightMargin;
        View view = new View(context);
        view.setLayoutParams(layoutParams);
        if (isFirst) {
            i3 = R.drawable.kyy;
        } else {
            i3 = R.drawable.kyx;
        }
        view.setBackgroundResource(i3);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(final int index) {
        this.clickTrigger.a(new Function0<Unit>(index) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardCoverPart$onClickCover$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $index;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$index = index;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardCoverPart.this, index);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TroopBasicInfoViewModel troopBasicInfoViewModel;
                TroopInfo i3;
                Activity activity;
                TroopBasicInfoViewModel troopBasicInfoViewModel2;
                TroopBasicInfoViewModel troopBasicInfoViewModel3;
                TroopAvatarCoverEditViewModel troopAvatarCoverEditViewModel;
                TroopBasicInfoViewModel troopBasicInfoViewModel4;
                List emptyList;
                List list;
                TroopAvatarCoverEditViewModel troopAvatarCoverEditViewModel2;
                TroopAvatarCoverEditViewModel troopAvatarCoverEditViewModel3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                troopBasicInfoViewModel = TroopInfoCardCoverPart.this.troopBasicInfoViewModel;
                if (troopBasicInfoViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopBasicInfoViewModel");
                    troopBasicInfoViewModel = null;
                }
                com.tencent.mobileqq.troop.data.v D2 = troopBasicInfoViewModel.D2();
                if (D2 == null || (i3 = D2.i()) == null || (activity = TroopInfoCardCoverPart.this.getActivity()) == null) {
                    return;
                }
                troopBasicInfoViewModel2 = TroopInfoCardCoverPart.this.troopBasicInfoViewModel;
                if (troopBasicInfoViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopBasicInfoViewModel");
                    troopBasicInfoViewModel2 = null;
                }
                if (!troopBasicInfoViewModel2.P2()) {
                    troopBasicInfoViewModel3 = TroopInfoCardCoverPart.this.troopBasicInfoViewModel;
                    if (troopBasicInfoViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("troopBasicInfoViewModel");
                        troopBasicInfoViewModel3 = null;
                    }
                    if (troopBasicInfoViewModel3.s2()) {
                        troopBasicInfoViewModel4 = TroopInfoCardCoverPart.this.troopBasicInfoViewModel;
                        if (troopBasicInfoViewModel4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("troopBasicInfoViewModel");
                            troopBasicInfoViewModel4 = null;
                        }
                        List<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f> value = troopBasicInfoViewModel4.A2().getValue();
                        if (value == null) {
                            emptyList = CollectionsKt__CollectionsKt.emptyList();
                            list = emptyList;
                        } else {
                            ArrayList arrayList = new ArrayList();
                            Iterator<T> it = value.iterator();
                            while (it.hasNext()) {
                                TroopClipPic b16 = ((com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f) it.next()).b();
                                if (b16 != null) {
                                    arrayList.add(b16);
                                }
                            }
                            list = arrayList;
                        }
                        troopAvatarCoverEditViewModel2 = TroopInfoCardCoverPart.this.avatarCoverEditViewModel;
                        if (troopAvatarCoverEditViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("avatarCoverEditViewModel");
                            troopAvatarCoverEditViewModel3 = null;
                        } else {
                            troopAvatarCoverEditViewModel3 = troopAvatarCoverEditViewModel2;
                        }
                        TroopAvatarCoverEditViewModel.Q1(troopAvatarCoverEditViewModel3, activity, TroopAvatarCoverEditViewModel.TroopAvatarCoverType.COVER, i3.isOwnerOrAdmin() && i3.hadJoinTroop(), i3, list, this.$index, null, null, 192, null);
                    } else if (i3.isOwnerOrAdmin() && i3.hadJoinTroop()) {
                        troopAvatarCoverEditViewModel = TroopInfoCardCoverPart.this.avatarCoverEditViewModel;
                        if (troopAvatarCoverEditViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("avatarCoverEditViewModel");
                            troopAvatarCoverEditViewModel = null;
                        }
                        troopAvatarCoverEditViewModel.T1(activity, TroopAvatarCoverEditViewModel.TroopAvatarCoverType.COVER);
                    }
                    ViewPager2 viewPager2 = TroopInfoCardCoverPart.this.coverViewPager;
                    if (viewPager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
                        viewPager2 = null;
                    }
                    VideoReport.reportEvent("dt_clck", viewPager2, null);
                    return;
                }
                com.tencent.mobileqq.troop.utils.ab.c(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9() {
        a aVar = this.adapter;
        ViewPager2 viewPager2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        if (aVar.getNUM_BACKGOURND_ICON() <= 1 || this.isAutoScrolling) {
            return;
        }
        QLog.i("TroopInfoCardCoverPart", 1, "startAutoScroll");
        ViewPager2 viewPager22 = this.coverViewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
        } else {
            viewPager2 = viewPager22;
        }
        viewPager2.postDelayed(this.autoScrollRunnable, 4000L);
        this.isAutoScrolling = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9() {
        QLog.i("TroopInfoCardCoverPart", 1, "stopAutoScroll");
        ViewPager2 viewPager2 = this.coverViewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
            viewPager2 = null;
        }
        viewPager2.removeCallbacks(this.autoScrollRunnable);
        this.isAutoScrolling = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(List<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f> imageList) {
        boolean z16;
        int a16;
        a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        aVar.setDataList(imageList);
        LinearLayoutCompat linearLayoutCompat = this.coverViewPagerIndicatorLayout;
        if (linearLayoutCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverViewPagerIndicatorLayout");
            linearLayoutCompat = null;
        }
        linearLayoutCompat.removeAllViews();
        this.indicatorDotList.clear();
        if (imageList.size() > 1) {
            int size = imageList.size();
            for (int i3 = 0; i3 < size; i3++) {
                LinearLayoutCompat linearLayoutCompat2 = this.coverViewPagerIndicatorLayout;
                if (linearLayoutCompat2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverViewPagerIndicatorLayout");
                    linearLayoutCompat2 = null;
                }
                Context context = linearLayoutCompat2.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "coverViewPagerIndicatorLayout.context");
                if (i3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (i3 == imageList.size() - 1) {
                    a16 = 0;
                } else {
                    a16 = com.tencent.mobileqq.utils.am.a(4.0f);
                }
                View J9 = J9(context, z16, a16);
                this.indicatorDotList.add(J9);
                LinearLayoutCompat linearLayoutCompat3 = this.coverViewPagerIndicatorLayout;
                if (linearLayoutCompat3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverViewPagerIndicatorLayout");
                    linearLayoutCompat3 = null;
                }
                linearLayoutCompat3.addView(J9);
            }
            M9();
            return;
        }
        N9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.uab);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.cover_viewpager)");
        this.coverViewPager = (ViewPager2) findViewById;
        View findViewById2 = rootView.findViewById(R.id.ukh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.dot_indicator_layout)");
        this.coverViewPagerIndicatorLayout = (LinearLayoutCompat) findViewById2;
        ViewPager2 viewPager2 = this.coverViewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
            viewPager2 = null;
        }
        a aVar = new a();
        this.adapter = aVar;
        viewPager2.setAdapter(aVar);
        ViewPager2 viewPager23 = this.coverViewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
            viewPager23 = null;
        }
        viewPager23.registerOnPageChangeCallback(new c());
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.troopBasicInfoViewModel;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopBasicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        LiveData<List<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f>> A2 = troopBasicInfoViewModel.A2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<List<? extends com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f>, Unit> function1 = new Function1<List<? extends com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f>, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardCoverPart$onInitView$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopInfoCardCoverPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f> list) {
                invoke2((List<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f> imageList) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) imageList);
                    return;
                }
                TroopInfoCardCoverPart troopInfoCardCoverPart = TroopInfoCardCoverPart.this;
                Intrinsics.checkNotNullExpressionValue(imageList, "imageList");
                troopInfoCardCoverPart.O9(imageList);
            }
        };
        A2.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.al
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardCoverPart.L9(Function1.this, obj);
            }
        });
        ViewPager2 viewPager24 = this.coverViewPager;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
        } else {
            viewPager22 = viewPager24;
        }
        TroopCardDtHelper.x(viewPager22);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        ViewModel viewModel = getViewModel(TroopBasicInfoViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopBasicInfoViewModel::class.java)");
        this.troopBasicInfoViewModel = (TroopBasicInfoViewModel) viewModel;
        ViewModel viewModel2 = getViewModel(TroopAvatarCoverEditViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(TroopAvatar\u2026ditViewModel::class.java)");
        this.avatarCoverEditViewModel = (TroopAvatarCoverEditViewModel) viewModel2;
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            N9();
        }
    }
}

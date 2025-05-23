package com.tencent.mobileqq.troop.edittroopinfo.parts.cover;

import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f;
import com.tencent.mobileqq.troop.troopcard.reborn.uimodel.g;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001)B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b'\u0010(J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0010\u0003\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u001c\u0010\u0015\u001a\u00020\n2\n\u0010\u0003\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/cover/TroopEditCoverAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/cover/TroopEditCoverAdapter$a;", "holder", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/f;", "coverUIModel", "Lcom/tencent/image/URLDrawable;", "n0", "", "imageList", "", "setDataList", "", com.tencent.luggage.wxa.c8.c.G, "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "q0", "getItemCount", "position", "o0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/cover/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/cover/e;", "callback", "", "D", "Ljava/util/List;", "Landroid/view/GestureDetector;", "E", "Lkotlin/Lazy;", "l0", "()Landroid/view/GestureDetector;", "gestureDetector", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/troop/edittroopinfo/parts/cover/e;)V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopEditCoverAdapter extends RecyclerView.Adapter<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final e callback;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<f> imageList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy gestureDetector;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/cover/TroopEditCoverAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "imageView", "<init>", "(Lcom/tencent/mobileqq/troop/edittroopinfo/parts/cover/TroopEditCoverAdapter;Landroid/widget/ImageView;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public final class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ImageView imageView;
        final /* synthetic */ TroopEditCoverAdapter F;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull TroopEditCoverAdapter troopEditCoverAdapter, ImageView imageView) {
            super(imageView);
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            this.F = troopEditCoverAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopEditCoverAdapter, (Object) imageView);
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

    public TroopEditCoverAdapter(@NotNull Context context, @NotNull e callback) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) callback);
            return;
        }
        this.context = context;
        this.callback = callback;
        this.imageList = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GestureDetector>() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.cover.TroopEditCoverAdapter$gestureDetector$2
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/troop/edittroopinfo/parts/cover/TroopEditCoverAdapter$gestureDetector$2$a", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapConfirmed", "onDown", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes19.dex */
            public static final class a extends GestureDetector.SimpleOnGestureListener {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ TroopEditCoverAdapter f295133d;

                a(TroopEditCoverAdapter troopEditCoverAdapter) {
                    this.f295133d = troopEditCoverAdapter;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopEditCoverAdapter);
                    }
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onDown(@Nullable MotionEvent e16) {
                    e eVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                        eVar = this.f295133d.callback;
                        eVar.a();
                        return true;
                    }
                    return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) e16)).booleanValue();
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onSingleTapConfirmed(@Nullable MotionEvent e16) {
                    e eVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        eVar = this.f295133d.callback;
                        eVar.b();
                        return super.onSingleTapConfirmed(e16);
                    }
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) e16)).booleanValue();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopEditCoverAdapter.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GestureDetector invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (GestureDetector) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = TroopEditCoverAdapter.this.context;
                return new GestureDetector(context2, new a(TroopEditCoverAdapter.this));
            }
        });
        this.gestureDetector = lazy;
    }

    private final GestureDetector l0() {
        return (GestureDetector) this.gestureDetector.getValue();
    }

    private final URLDrawable n0(a holder, f coverUIModel) {
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
        com.tencent.mobileqq.troop.avatar.a a16 = g.a(coverUIModel);
        if (a16 != null) {
            str = a16.f294536h;
        }
        if (str == null) {
            str = "";
        }
        iTroopPhotoUtilsApi.getClipRect(rect, str);
        URLDrawable drawable = URLDrawable.getDrawable(uRL4TroopPhoto, obtain);
        drawable.setTag(((ITroopCardApi) QRoute.api(ITroopCardApi.class)).buildCustomClipDecoderParams(rect.left, rect.top, rect.width(), rect.height(), holder.l().getWidth(), holder.l().getHeight()));
        Object _custom_clip_decoder = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).get_CUSTOM_CLIP_DECODER();
        Intrinsics.checkNotNull(_custom_clip_decoder, "null cannot be cast to non-null type com.tencent.image.DownloadParams.DecodeHandler");
        drawable.setDecodeHandler((DownloadParams.DecodeHandler) _custom_clip_decoder);
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p0(TroopEditCoverAdapter this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 1) {
            this$0.callback.c();
        }
        return this$0.l0().onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        if (this.imageList.size() <= 1) {
            return this.imageList.size();
        }
        return this.imageList.size() + 2;
    }

    public final int m0(int pos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, pos)).intValue();
        }
        if (getItemCount() <= 1) {
            return pos;
        }
        return pos % this.imageList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.l().setImageDrawable(n0(holder, this.imageList.get(m0(position))));
        holder.l().setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.cover.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean p06;
                p06 = TroopEditCoverAdapter.p0(TroopEditCoverAdapter.this, view, motionEvent);
                return p06;
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        RoundImageView roundImageView = new RoundImageView(parent.getContext());
        roundImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        roundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new a(this, roundImageView);
    }

    public final void setDataList(@NotNull List<f> imageList) {
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

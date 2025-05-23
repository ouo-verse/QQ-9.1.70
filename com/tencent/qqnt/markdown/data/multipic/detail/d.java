package com.tencent.qqnt.markdown.data.multipic.detail;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRectImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\b)\u0010*J\u001a\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fJ6\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0002R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/qqnt/markdown/data/multipic/detail/d;", "", "", "width", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "f", "Landroid/graphics/drawable/Drawable;", "drawable", "g", "height", "", "k", "Landroid/widget/FrameLayout;", h.F, "Lcom/tencent/qqnt/markdown/data/multipic/detail/b;", "listener", "i", "", "url", "itemWidth", "", CoverDBCacheData.URLS, "currentPosition", "j", "Lcom/tencent/widget/RoundRectImageView;", "a", "Lcom/tencent/widget/RoundRectImageView;", "imageView", "b", "Lcom/tencent/qqnt/markdown/data/multipic/detail/b;", "onClickListener", "c", "Ljava/util/List;", "d", "I", "e", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RoundRectImageView imageView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.markdown.data.multipic.detail.b onClickListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<String> urls;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int currentPosition;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout container;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/markdown/data/multipic/detail/d$a;", "", "", "ITEM_PADDING", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.markdown.data.multipic.detail.d$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/markdown/data/multipic/detail/d$b", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements IPicLoadStateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f359390e;

        b(int i3) {
            this.f359390e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, i3);
            }
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@Nullable LoadState state, @Nullable Option option) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) state, (Object) option);
                return;
            }
            if (option != null) {
                d dVar = d.this;
                int i3 = this.f359390e;
                boolean z16 = false;
                if (state != null && true == state.isFinishSuccess()) {
                    z16 = true;
                }
                if (z16) {
                    int requestHeight = option.getRequestHeight();
                    if (option.getResultBitMap() != null) {
                        requestHeight = dVar.f(i3, option.getResultBitMap());
                    } else if (option.getResource() != null) {
                        Object obj = option.getResource().get();
                        if (obj instanceof Drawable) {
                            requestHeight = dVar.g(i3, (Drawable) obj);
                        } else if (obj instanceof Bitmap) {
                            requestHeight = dVar.f(i3, (Bitmap) obj);
                        } else {
                            QLog.i("PicDetailViewWrapper", 1, "in resource check failed: state:" + state + ", " + obj);
                        }
                    }
                    dVar.k(i3, requestHeight);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35176);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        RoundRectImageView roundRectImageView = new RoundRectImageView(context);
        roundRectImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        roundRectImageView.setCornerRadiusAndMode(ViewUtils.dpToPx(4.0f), 1);
        roundRectImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.imageView = roundRectImageView;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.markdown.data.multipic.detail.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.e(d.this, context, view);
            }
        });
        this.container = frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(d this$0, Context context, View view) {
        com.tencent.qqnt.markdown.data.multipic.detail.b bVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        List<String> list = this$0.urls;
        if (list != null && (bVar = this$0.onClickListener) != null) {
            bVar.a(context, list, this$0.currentPosition);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int f(int width, Bitmap bitmap) {
        if (bitmap != null && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            int height = (bitmap.getHeight() * width) / bitmap.getWidth();
            if (QLog.isColorLevel()) {
                QLog.i("PicDetailViewWrapper", 1, "getBitmapHeight width:" + width + ", height:" + height + ", bitmap.width:" + bitmap.getWidth() + ", bitmap.height:" + bitmap.getHeight());
            }
            return height;
        }
        return width;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int g(int width, Drawable drawable) {
        if (drawable != null && drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            int intrinsicHeight = (drawable.getIntrinsicHeight() * width) / drawable.getIntrinsicWidth();
            if (QLog.isColorLevel()) {
                QLog.i("PicDetailViewWrapper", 1, "getDrawableHeight width:" + width + ", height:" + intrinsicHeight + ", drawable.intrinsicWidth:" + drawable.getIntrinsicWidth() + ", drawable.intrinsicHeight:" + drawable.getIntrinsicHeight());
            }
            return intrinsicHeight;
        }
        return width;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(int width, int height) {
        ViewGroup.LayoutParams layoutParams = this.imageView.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.imageView.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.container.getLayoutParams();
        layoutParams2.width = width + ViewUtils.dpToPx(4.0f);
        layoutParams2.height = height + ViewUtils.dpToPx(4.0f);
        this.container.setLayoutParams(layoutParams2);
    }

    @NotNull
    public final FrameLayout h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.container;
    }

    public final void i(@NotNull com.tencent.qqnt.markdown.data.multipic.detail.b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.onClickListener = listener;
        }
    }

    public final void j(@NotNull String url, int itemWidth, int height, @Nullable List<String> urls, int currentPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, url, Integer.valueOf(itemWidth), Integer.valueOf(height), urls, Integer.valueOf(currentPosition));
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        this.urls = urls;
        this.currentPosition = currentPosition;
        this.container.removeAllViews();
        this.container.setLayoutParams(new RecyclerView.LayoutParams(itemWidth, height));
        int dpToPx = ViewUtils.dpToPx(4.0f) / 2;
        this.container.setPadding(dpToPx, dpToPx, dpToPx, dpToPx);
        int i3 = itemWidth - (dpToPx * 2);
        Option options = Option.obtain().setTargetView(this.imageView).setUrl(url);
        IPicAIOApi iPicAIOApi = (IPicAIOApi) QRoute.api(IPicAIOApi.class);
        Intrinsics.checkNotNullExpressionValue(options, "options");
        iPicAIOApi.loadPic(options, new b(i3));
        this.container.addView(this.imageView);
    }
}

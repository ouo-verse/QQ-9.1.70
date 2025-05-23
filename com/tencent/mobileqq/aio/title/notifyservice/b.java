package com.tencent.mobileqq.aio.title.notifyservice;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.title.notifyservice.NotifyServiceTitleUIState;
import com.tencent.mobileqq.aio.title.notifyservice.a;
import com.tencent.mobileqq.aio.widget.AIOTitleRelativeLayout;
import com.tencent.mobileqq.aio.widget.CommonTextView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 =2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001>B\u0017\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010-\u001a\u00020*\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0016\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00110\u0010H\u0016J\u001c\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0003H\u0016JF\u0010%\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010#R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/aio/title/notifyservice/b;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/title/notifyservice/a;", "Lcom/tencent/mobileqq/aio/title/notifyservice/NotifyServiceTitleUIState;", "", TagValue.MOSAIC, "", "e1", "Lcom/tencent/mobileqq/aio/title/notifyservice/d;", "data", "d1", "f1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "", "Ljava/lang/Class;", "getObserverStates", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "bindViewAndData", "state", "c1", "Landroid/widget/ImageView;", "imageView", "", LayoutAttrDefine.CLICK_URI, "Landroid/graphics/drawable/Drawable;", "failed", ToastView.ICON_LOADING, "", "width", "height", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "listener", "b1", "Lcom/tencent/mobileqq/aio/widget/AIOTitleRelativeLayout;", "d", "Lcom/tencent/mobileqq/aio/widget/AIOTitleRelativeLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewStub;", "e", "Landroid/view/ViewStub;", "tabViewStub", "f", "Landroid/view/View;", "mLeftInfoView", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", h.F, "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "mAvatarView", "Lcom/tencent/mobileqq/aio/widget/CommonTextView;", "i", "Lcom/tencent/mobileqq/aio/widget/CommonTextView;", "mTitleView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mSubTitleView", "<init>", "(Lcom/tencent/mobileqq/aio/widget/AIOTitleRelativeLayout;Landroid/view/ViewStub;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b extends com.tencent.aio.base.mvvm.a<a, NotifyServiceTitleUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOTitleRelativeLayout parent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewStub tabViewStub;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mLeftInfoView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RoundRectImageView mAvatarView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CommonTextView mTitleView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CommonTextView mSubTitleView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/title/notifyservice/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.title.notifyservice.b$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65206);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull AIOTitleRelativeLayout parent, @NotNull ViewStub tabViewStub) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(tabViewStub, "tabViewStub");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parent, (Object) tabViewStub);
        } else {
            this.parent = parent;
            this.tabViewStub = tabViewStub;
        }
    }

    private final void d1(d data) {
        RoundRectImageView roundRectImageView;
        CommonTextView commonTextView;
        if (!data.d()) {
            return;
        }
        if (this.mLeftInfoView == null) {
            this.mLeftInfoView = this.tabViewStub.inflate();
        }
        View view = this.mLeftInfoView;
        if (view != null) {
            view.setVisibility(0);
        }
        ((CommonTextView) this.parent.findViewById(R.id.f98175md)).setVisibility(8);
        View view2 = this.mLeftInfoView;
        CommonTextView commonTextView2 = null;
        if (view2 != null) {
            roundRectImageView = (RoundRectImageView) view2.findViewById(R.id.f166439zv2);
        } else {
            roundRectImageView = null;
        }
        this.mAvatarView = roundRectImageView;
        View view3 = this.mLeftInfoView;
        if (view3 != null) {
            commonTextView = (CommonTextView) view3.findViewById(R.id.f166440zv3);
        } else {
            commonTextView = null;
        }
        this.mTitleView = commonTextView;
        View view4 = this.mLeftInfoView;
        if (view4 != null) {
            commonTextView2 = (CommonTextView) view4.findViewById(R.id.f166438zv1);
        }
        this.mSubTitleView = commonTextView2;
        CommonTextView commonTextView3 = this.mTitleView;
        if (commonTextView3 != null) {
            commonTextView3.setText(data.b());
        }
        CommonTextView commonTextView4 = this.mSubTitleView;
        if (commonTextView4 != null) {
            commonTextView4.setText(data.c());
        }
        f1(data);
    }

    private final void e1(boolean mosaic) {
        QLog.d("NotifyServiceTitleVB", 1, "mosaic=" + mosaic);
    }

    private final void f1(d data) {
        RoundRectImageView roundRectImageView = this.mAvatarView;
        if (roundRectImageView != null) {
            roundRectImageView.setCornerRadiusAndMode(ViewUtils.dip2px(16.0f), 1);
        }
        Drawable drawable = getMContext().getDrawable(R.drawable.f160830com);
        int dip2px = ViewUtils.dip2px(16.0f);
        b1(this.mAvatarView, data.a(), drawable, drawable, dip2px, dip2px, null);
    }

    public final void b1(@Nullable ImageView imageView, @NotNull String uri, @Nullable Drawable failed, @Nullable Drawable loading, int width, int height, @Nullable URLDrawable.URLDrawableListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, imageView, uri, failed, loading, Integer.valueOf(width), Integer.valueOf(height), listener);
            return;
        }
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (imageView != null && !TextUtils.isEmpty(uri)) {
            if (QLog.isColorLevel()) {
                QLog.d("NotifyServiceTitleVB", 2, "uri:" + uri + ",width:" + width + ",height:" + height);
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            if (width > 0 && height > 0) {
                obtain.mRequestWidth = width;
                obtain.mRequestHeight = height;
            }
            if (failed == null) {
                failed = com.tencent.mobileqq.urldrawable.b.f306350a;
            }
            obtain.mFailedDrawable = failed;
            if (loading == null) {
                loading = com.tencent.mobileqq.urldrawable.b.f306350a;
            }
            obtain.mLoadingDrawable = loading;
            obtain.mMemoryCacheKeySuffix = "now";
            obtain.mUseAutoScaleParams = false;
            URLDrawable drawable = URLDrawable.getDrawable(uri, obtain);
            if (listener != null) {
                if (drawable.getStatus() == 1) {
                    QLog.d("NotifyServiceTitleVB", 1, "URLDrawable's status is SUCCESSED.");
                    listener.onLoadSuccessed(drawable);
                } else {
                    QLog.d("NotifyServiceTitleVB", 1, "start load URLDrawable.");
                }
                drawable.setURLDrawableListener(listener);
            }
            imageView.setImageDrawable(drawable);
            return;
        }
        QLog.e("NotifyServiceTitleVB", 1, "ImageView or uri is null.");
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.bindViewAndData();
            sendIntent(a.C7363a.f193991d);
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull NotifyServiceTitleUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof NotifyServiceTitleUIState.UpdateNotifyServiceTitle) {
            d1(((NotifyServiceTitleUIState.UpdateNotifyServiceTitle) state).a());
        } else if (state instanceof NotifyServiceTitleUIState.UpdateNotifyTitleShotMosaic) {
            e1(((NotifyServiceTitleUIState.UpdateNotifyTitleShotMosaic) state).a());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<a, NotifyServiceTitleUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BaseVM) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new c();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends NotifyServiceTitleUIState>> getObserverStates() {
        List<Class<? extends NotifyServiceTitleUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(NotifyServiceTitleUIState.UpdateNotifyServiceTitle.class);
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return this.tabViewStub;
    }
}

package com.tencent.qqnt.chats.core.itempart.avatar.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.view.api.IRecentAvatarApi;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chats/core/itempart/avatar/provider/b;", "Lcom/tencent/qqnt/chats/inject/avatar/c;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "Landroid/widget/ImageView;", "view", "", "c", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/drawable/Drawable;", "d", "Ljava/lang/ref/WeakReference;", "drawableRef", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b extends com.tencent.qqnt.chats.inject.avatar.c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Drawable> drawableRef;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/chats/core/itempart/avatar/provider/b$a", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements IPicLoadStateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference<ImageView> f354781d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g f354782e;

        a(WeakReference<ImageView> weakReference, g gVar) {
            this.f354781d = weakReference;
            this.f354782e = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference, (Object) gVar);
            }
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@Nullable LoadState state, @Nullable Option option) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) state, (Object) option);
                return;
            }
            ImageView imageView = this.f354781d.get();
            if (imageView != null && option != null && Intrinsics.areEqual(imageView.getTag(R.id.x8s), Long.valueOf(this.f354782e.l())) && option.getResultBitMap() != null) {
                if (state == null || state.isFinishSuccess()) {
                    imageView.setImageBitmap(option.getResultBitMap());
                }
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.inject.avatar.c
    public boolean b(@NotNull g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        return true;
    }

    @Override // com.tencent.qqnt.chats.inject.avatar.c
    public void c(@NotNull g item, @NotNull ImageView view) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        WeakReference<Drawable> weakReference = this.drawableRef;
        if (weakReference != null) {
            drawable = weakReference.get();
        } else {
            drawable = null;
        }
        if (drawable == null) {
            drawable = view.getResources().getDrawable(R.drawable.f160830com);
            this.drawableRef = new WeakReference<>(drawable);
        }
        String d16 = item.g().d();
        view.setImageDrawable(drawable);
        if (!TextUtils.isEmpty(d16)) {
            IRecentAvatarApi iRecentAvatarApi = (IRecentAvatarApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRecentAvatarApi.class);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            int recentAvatarSize = iRecentAvatarApi.getRecentAvatarSize(context);
            Option options = Option.obtain().setUrl(d16).setRequestHeight(recentAvatarSize).setRequestWidth(recentAvatarSize);
            WeakReference weakReference2 = new WeakReference(view);
            IPicAIOApi iPicAIOApi = (IPicAIOApi) QRoute.api(IPicAIOApi.class);
            Intrinsics.checkNotNullExpressionValue(options, "options");
            iPicAIOApi.loadPic(options, new a(weakReference2, item));
        }
    }
}

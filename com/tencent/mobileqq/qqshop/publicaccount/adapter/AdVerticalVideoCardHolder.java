package com.tencent.mobileqq.qqshop.publicaccount.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0014J4\u0010\u0014\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\u0015\u001a\u00020\u000bH\u0014R\u0014\u0010\u0018\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/AdVerticalVideoCardHolder;", "Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/AdVideoCardHolder;", "Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/p;", "adCardModel", "", "x0", "y0", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "B0", "headCardModel", "", "headPosition", "B", "o0", "Lcom/tencent/superplayer/api/ISuperPlayer;", "player", "id", "width", "height", "m0", "k0", "g0", "I", "adCardHeight", "h0", "mediaWidth", "Landroid/view/ViewGroup;", "itemView", "<init>", "(Landroid/view/ViewGroup;)V", "i0", "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class AdVerticalVideoCardHolder extends AdVideoCardHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private final int adCardHeight;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private int mediaWidth;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/AdVerticalVideoCardHolder$a;", "", "", "DEFAULT_VERTICAL_RATIO", UserInfo.SEX_FEMALE, "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.publicaccount.adapter.AdVerticalVideoCardHolder$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31184);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdVerticalVideoCardHolder(@NotNull ViewGroup itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
        } else {
            this.adCardHeight = ib1.a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(AdVerticalVideoCardHolder this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B0(null, bitmap);
    }

    private final void B0(p adCardModel, Bitmap bitmap) {
        ImageView imageView = (ImageView) this.itemView.findViewById(R.id.sbd);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = this.adCardHeight;
        layoutParams.width = this.mediaWidth;
        if (bitmap != null) {
            imageView.setImageDrawable(new BitmapDrawable(imageView.getResources(), bitmap));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else if (adCardModel != null) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestHeight = this.adCardHeight;
            obtain.mRequestWidth = this.mediaWidth;
            imageView.setImageDrawable(URLDrawable.getDrawable(adCardModel.e(), obtain));
        }
        this.itemView.findViewById(R.id.sbe).setVisibility(0);
        this.itemView.findViewById(R.id.sbf).setVisibility(0);
    }

    private final void x0(p adCardModel) {
        ImageView t16 = t();
        URLDrawable drawable = URLDrawable.getDrawable(adCardModel.e(), (URLDrawable.URLDrawableOptions) null);
        drawable.setDecodeHandler(com.tencent.mobileqq.qwallet.utils.b.f279250a.b());
        t16.setImageDrawable(drawable);
    }

    private final void y0(final p adCardModel) {
        w().post(new Runnable() { // from class: com.tencent.mobileqq.qqshop.publicaccount.adapter.f
            @Override // java.lang.Runnable
            public final void run() {
                AdVerticalVideoCardHolder.z0(AdVerticalVideoCardHolder.this, adCardModel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(AdVerticalVideoCardHolder this$0, p adCardModel) {
        float f16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adCardModel, "$adCardModel");
        float height = this$0.w().getHeight();
        Float j3 = adCardModel.j();
        if (j3 != null) {
            f16 = j3.floatValue();
        } else {
            f16 = 0.56f;
        }
        this$0.w().getLayoutParams().width = (int) (height * f16);
    }

    @Override // com.tencent.mobileqq.qqshop.publicaccount.adapter.AdVideoCardHolder, com.tencent.mobileqq.qqshop.publicaccount.adapter.AdCardHolder
    public void B(@NotNull p headCardModel, int headPosition) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) headCardModel, headPosition);
            return;
        }
        Intrinsics.checkNotNullParameter(headCardModel, "headCardModel");
        super.B(headCardModel, headPosition);
        float f17 = this.adCardHeight;
        Float j3 = headCardModel.j();
        if (j3 != null) {
            f16 = j3.floatValue();
        } else {
            f16 = 0.56f;
        }
        this.mediaWidth = (int) (f17 * f16);
        x0(headCardModel);
        B0(headCardModel, null);
        y0(headCardModel);
    }

    @Override // com.tencent.mobileqq.qqshop.publicaccount.adapter.AdVideoCardHolder
    protected int k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqshop.publicaccount.adapter.AdVideoCardHolder
    protected void m0(@Nullable ISuperPlayer player, int id5, int width, int height, @Nullable final Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, player, Integer.valueOf(id5), Integer.valueOf(width), Integer.valueOf(height), bitmap);
            return;
        }
        super.m0(player, id5, width, height, bitmap);
        QLog.i("AdCardHolder", 1, "onCaptureImageSucceed:" + width + " " + height);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqshop.publicaccount.adapter.e
            @Override // java.lang.Runnable
            public final void run() {
                AdVerticalVideoCardHolder.A0(AdVerticalVideoCardHolder.this, bitmap);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqshop.publicaccount.adapter.AdVideoCardHolder
    protected void o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.o0();
        ISuperPlayer i06 = i0();
        if (i06 != null) {
            i06.captureImageInTime(500L, 0, 0);
        }
    }
}

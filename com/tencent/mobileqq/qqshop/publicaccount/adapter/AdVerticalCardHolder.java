package com.tencent.mobileqq.qqshop.publicaccount.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/AdVerticalCardHolder;", "Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/AdCardHolder;", "Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/p;", "adCardModel", "", "T", "U", "headCardModel", "", "headPosition", "B", "Landroid/view/ViewGroup;", "itemView", "<init>", "(Landroid/view/ViewGroup;)V", "Y", "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class AdVerticalCardHolder extends AdCardHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/AdVerticalCardHolder$a;", "", "", "DEFAULT_VERTICAL_RATIO", UserInfo.SEX_FEMALE, "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.publicaccount.adapter.AdVerticalCardHolder$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31159);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdVerticalCardHolder(@NotNull ViewGroup itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
        }
    }

    private final void T(p adCardModel) {
        ImageView t16 = t();
        URLDrawable drawable = URLDrawable.getDrawable(adCardModel.e(), (URLDrawable.URLDrawableOptions) null);
        drawable.setDecodeHandler(com.tencent.mobileqq.qwallet.utils.b.f279250a.b());
        t16.setImageDrawable(drawable);
    }

    private final void U(p adCardModel) {
        float f16;
        ImageView imageView = (ImageView) this.itemView.findViewById(R.id.sbd);
        int a16 = ib1.a.a();
        float f17 = a16;
        Float j3 = adCardModel.j();
        if (j3 != null) {
            f16 = j3.floatValue();
        } else {
            f16 = 0.56f;
        }
        int i3 = (int) (f17 * f16);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = a16;
        layoutParams.width = i3;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestHeight = a16;
        obtain.mRequestWidth = i3;
        URLDrawable drawable = URLDrawable.getDrawable(adCardModel.e(), obtain);
        drawable.setDecodeHandler(null);
        imageView.setImageDrawable(drawable);
        this.itemView.findViewById(R.id.sbe).setVisibility(0);
        this.itemView.findViewById(R.id.sbf).setVisibility(8);
    }

    @Override // com.tencent.mobileqq.qqshop.publicaccount.adapter.AdCardHolder
    public void B(@NotNull p headCardModel, int headPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) headCardModel, headPosition);
            return;
        }
        Intrinsics.checkNotNullParameter(headCardModel, "headCardModel");
        super.B(headCardModel, headPosition);
        T(headCardModel);
        U(headCardModel);
    }
}

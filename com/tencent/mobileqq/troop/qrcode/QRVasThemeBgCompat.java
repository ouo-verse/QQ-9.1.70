package com.tencent.mobileqq.troop.qrcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.theme.SkinnableBitmapDrawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/QRVasThemeBgCompat;", "", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "", "callback", "a", "Landroid/view/View;", "bgView", "c", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class QRVasThemeBgCompat {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QRVasThemeBgCompat f298153a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62214);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f298153a = new QRVasThemeBgCompat();
        }
    }

    QRVasThemeBgCompat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(Context context, final Function1<? super Boolean, Unit> callback) {
        if (!QQTheme.isVasTheme()) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        Drawable drawable = resources.getDrawable(R.drawable.qui_common_bg_bottom_standard_bg, null);
        if (drawable instanceof SkinnableBitmapDrawable) {
            SkinnableBitmapDrawable skinnableBitmapDrawable = (SkinnableBitmapDrawable) drawable;
            if (skinnableBitmapDrawable.getBitmap() != null) {
                com.tencent.mobileqq.component.qrcode.utils.c cVar = com.tencent.mobileqq.component.qrcode.utils.c.f201870a;
                Bitmap bitmap = skinnableBitmapDrawable.getBitmap();
                Intrinsics.checkNotNullExpressionValue(bitmap, "drawable.bitmap");
                cVar.f(bitmap, new Function1<Integer, Unit>(callback) { // from class: com.tencent.mobileqq.troop.qrcode.QRVasThemeBgCompat$isVasThemeLight$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Function1<Boolean, Unit> $callback;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                        this.$callback = callback;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) callback);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            this.$callback.invoke(Boolean.valueOf(com.tencent.mobileqq.component.qrcode.utils.c.f201870a.c(i3)));
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this, i3);
                        }
                    }
                });
                return;
            }
        }
        callback.invoke(Boolean.FALSE);
    }

    public final void b(@NotNull final View bgView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bgView);
            return;
        }
        Intrinsics.checkNotNullParameter(bgView, "bgView");
        if (!QQTheme.isVasTheme()) {
            bgView.setBackgroundResource(R.drawable.kbf);
            bgView.getBackground().setAlpha(255);
            return;
        }
        bgView.setBackgroundResource(R.drawable.kbg);
        Context context = bgView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "bgView.context");
        a(context, new Function1<Boolean, Unit>(bgView) { // from class: com.tencent.mobileqq.troop.qrcode.QRVasThemeBgCompat$refreshBottomTipsCardBg$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ View $bgView;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$bgView = bgView;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) bgView);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                } else if (z16) {
                    this.$bgView.getBackground().setTint(-1);
                } else {
                    this.$bgView.getBackground().setTint(-16777216);
                }
            }
        });
        bgView.getBackground().setAlpha(216);
    }

    public final void c(@NotNull final View bgView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bgView);
            return;
        }
        Intrinsics.checkNotNullParameter(bgView, "bgView");
        if (!QQTheme.isVasTheme()) {
            bgView.setBackgroundResource(R.drawable.kb_);
            bgView.getBackground().setAlpha(255);
            return;
        }
        bgView.setBackgroundResource(R.drawable.f161485kb3);
        Context context = bgView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "bgView.context");
        a(context, new Function1<Boolean, Unit>(bgView) { // from class: com.tencent.mobileqq.troop.qrcode.QRVasThemeBgCompat$refreshQRCodeCardBg$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ View $bgView;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$bgView = bgView;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) bgView);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                } else if (z16) {
                    this.$bgView.getBackground().setTint(-1);
                } else {
                    this.$bgView.getBackground().setTint(-16777216);
                }
            }
        });
        bgView.getBackground().setAlpha(216);
    }
}

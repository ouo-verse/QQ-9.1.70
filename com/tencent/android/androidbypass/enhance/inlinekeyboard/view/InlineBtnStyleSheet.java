package com.tencent.android.androidbypass.enhance.inlinekeyboard.view;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface InlineBtnStyleSheet {
    public static final IPatchRedirector $redirector_ = null;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class BtnType {
        private static final /* synthetic */ BtnType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final BtnType ENTER;
        public static final BtnType NORMAL;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10551);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            BtnType btnType = new BtnType(QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, 0);
            NORMAL = btnType;
            BtnType btnType2 = new BtnType("ENTER", 1);
            ENTER = btnType2;
            $VALUES = new BtnType[]{btnType, btnType2};
        }

        BtnType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static BtnType valueOf(String str) {
            return (BtnType) Enum.valueOf(BtnType.class, str);
        }

        public static BtnType[] values() {
            return (BtnType[]) $VALUES.clone();
        }
    }

    @DrawableRes
    int a();

    @Nullable
    Drawable b();

    @Nullable
    Drawable c();

    int d();

    @NonNull
    ColorStateList e();

    @Nullable
    Drawable f();

    @Nullable
    Drawable g();

    @DrawableRes
    int getIconRes();

    BtnType getType();

    @DrawableRes
    int h();
}

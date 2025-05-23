package com.tencent.mobileqq.qui.immersive.color;

import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IColorFetcher {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class Area {
        private static final /* synthetic */ Area[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Area BOTTOM;
        public static final Area TOP;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50628);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            Area area = new Area("TOP", 0);
            TOP = area;
            Area area2 = new Area("BOTTOM", 1);
            BOTTOM = area2;
            $VALUES = new Area[]{area, area2};
        }

        Area(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static Area valueOf(String str) {
            return (Area) Enum.valueOf(Area.class, str);
        }

        public static Area[] values() {
            return (Area[]) $VALUES.clone();
        }
    }

    boolean canHandle(Drawable drawable);

    boolean canHandle(View view);

    Pair<Boolean, Integer> getColor(Drawable drawable, Area area);

    Pair<Boolean, Integer> getColor(View view, Area area);
}

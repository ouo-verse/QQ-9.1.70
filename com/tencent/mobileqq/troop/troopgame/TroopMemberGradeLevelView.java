package com.tencent.mobileqq.troop.troopgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopMemberGradeLevelView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private static final int f300252i;

    /* renamed from: m, reason: collision with root package name */
    private static final int f300253m;

    /* renamed from: d, reason: collision with root package name */
    private int f300254d;

    /* renamed from: e, reason: collision with root package name */
    private final int f300255e;

    /* renamed from: f, reason: collision with root package name */
    private final String f300256f;

    /* renamed from: h, reason: collision with root package name */
    private final ImageView f300257h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76668);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f300252i = ViewUtils.dip2px(16.0f);
            f300253m = ViewUtils.dip2px(16.0f);
        }
    }

    public TroopMemberGradeLevelView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private String b(int i3, int i16, String str) {
        switch (i3) {
            case 2:
                return str + "1";
            case 3:
                return str + "2";
            case 4:
                return str + "3";
            case 5:
                return str + "4";
            case 6:
                return str + "5";
            case 7:
                return str + "6";
            case 8:
                if (i16 > 5) {
                    return str + "8";
                }
                return str + "7";
            default:
                return null;
        }
    }

    private String c(int i3, String str) {
        if (!TextUtils.isEmpty(str)) {
            switch (i3) {
                case 5:
                    return str + "5";
                case 6:
                    return str + "4";
                case 7:
                    return str + "3";
                case 8:
                    return str + "2";
                case 9:
                    return str + "1";
                default:
                    return null;
            }
        }
        return str;
    }

    public Bitmap a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bitmap) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        int i3 = this.f300254d;
        if (i3 <= 0) {
            return null;
        }
        int i16 = i3 / 100000;
        int i17 = (i3 % 100000) / 10000;
        String b16 = b(i16, i17, c.e() + "aio_game_grade_");
        if (TextUtils.isEmpty(b16)) {
            return null;
        }
        if (i16 != 8) {
            b16 = c(i17, b16 + "_");
            if (TextUtils.isEmpty(b16)) {
                return null;
            }
        }
        return ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap(b16 + ".png");
    }

    public void d(MemberGradeLevelInfo memberGradeLevelInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) memberGradeLevelInfo);
            return;
        }
        setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f300252i, f300253m);
        String cardResPath = VasUtil.getService().getGameCardManager().getCardResPath(2, memberGradeLevelInfo.gameCardId);
        if (TextUtils.isEmpty(cardResPath)) {
            this.f300257h.setImageDrawable(null);
            return;
        }
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(cardResPath, new ApngOptions(), cardResPath);
        this.f300257h.setLayoutParams(layoutParams);
        if (apngURLDrawable != null) {
            this.f300257h.setImageDrawable(apngURLDrawable);
            setVisibility(0);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberGradeLevelView", 2, "new_game_card aio bitmap null");
            }
            this.f300257h.setImageDrawable(null);
        }
    }

    public void e(MemberGradeLevelInfo memberGradeLevelInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) memberGradeLevelInfo);
            return;
        }
        setVisibility(8);
        this.f300254d = memberGradeLevelInfo.gradeLevel;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f300252i, f300253m);
        Bitmap a16 = a();
        this.f300257h.setLayoutParams(layoutParams);
        if (a16 != null) {
            this.f300257h.setImageBitmap(a16);
            setVisibility(0);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberGradeLevelView", 2, "setTroopMemberGradeLevel bitmap is null");
            }
            this.f300257h.setImageBitmap(null);
        }
    }

    public void setTroopMemberGradeLevel(MemberGradeLevelInfo memberGradeLevelInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) memberGradeLevelInfo);
            return;
        }
        if (memberGradeLevelInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberGradeLevelView", 2, "new_game_card info is null");
            }
            setVisibility(8);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberGradeLevelView", 2, "new_game_card memUin: " + memberGradeLevelInfo.toString());
        }
        if (memberGradeLevelInfo.gameCardSwitch == 1 && memberGradeLevelInfo.gradeLevel > 0) {
            e(memberGradeLevelInfo);
        } else {
            d(memberGradeLevelInfo);
        }
    }

    public TroopMemberGradeLevelView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TroopMemberGradeLevelView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f300254d = -1;
        this.f300255e = 8;
        this.f300256f = ".png";
        setOrientation(0);
        ImageView imageView = new ImageView(context);
        this.f300257h = imageView;
        addView(imageView);
    }
}

package com.tencent.mobileqq.troop.api.troopmemberlist;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopMemberListActivityApi extends QRouteApi {
    public static final int USER_TYPE_SVIP = 2;
    public static final int USER_TYPE_VIP = 1;
    public static final int USER_TYPE_YEAR_SVIP = 4;
    public static final int USER_TYPE_YEAR_VIP = 3;
    public static final int VIP_TYPE_SUPERVIP = 3;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static abstract class a {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public abstract void a(int i3, String str);

        public abstract void b(long[] jArr, long[] jArr2, long[] jArr3);
    }

    void clothEffectView(Context context, ViewGroup viewGroup, int i3, String str);

    SpannableString createColorNickText(CharSequence charSequence, int i3);

    String getAccountNickName(AppInterface appInterface, String str);

    com.tencent.mobileqq.troop.api.troopmemberlist.a getAddFrdStateMngProxy(AppInterface appInterface);

    int getBigClubFlag(int i3);

    String getConfigContentForTag(String str, String str2);

    int getCurrentUserVipType(AppInterface appInterface);

    Drawable getDefaultTroopFaceDrawableNew();

    c getFacePreloadBaseAdapterProxy(b bVar, Context context, AppInterface appInterface, Object obj, int i3, boolean z16);

    Object getFriendListObserverForAddFrd(d dVar);

    int getVipTypeByFlag(int i3);

    void handleRichLevel(int i3, byte b16, Object obj);

    void handleRichLevelWithParsedTag(int i3, int i16, Object obj);

    int hrExtra(long j3);

    boolean isHRConf(long j3);

    boolean isNoRight(int i3);

    boolean isPSTNConf(long j3);

    void openTroopFileBrowserActivity(Activity activity, String str, String str2, String str3, String str4, int i3);

    void openTroopmemberCard(AppInterface appInterface, Context context, String str, String str2, int i3, Bundle bundle);

    void reportDC00087(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6);

    void requestGiftMemberList(AppInterface appInterface, String str, a aVar);

    void setColorText(AppInterface appInterface, TextView textView, Spannable spannable);

    void setCustomCloth(TextView textView, Context context, int i3, boolean z16);

    void startEditUniqueTitleActivity(Activity activity, String str, String str2, int i3, String str3, int i16);

    void startSelectMemberActivity(Activity activity, String str, String str2, int i3);

    void startSelectTroopMemberFragment(Activity activity, boolean z16, int i3, String str, int i16);

    void startSelectTroopMemberFragment(Activity activity, boolean z16, String str, int i3);
}

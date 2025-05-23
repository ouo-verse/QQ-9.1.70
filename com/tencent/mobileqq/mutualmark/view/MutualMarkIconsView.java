package com.tencent.mobileqq.mutualmark.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.info.c;
import com.tencent.mobileqq.mutualmark.oldlogic.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.BaselineTextView;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MutualMarkIconsView extends LinearLayout {
    static IPatchRedirector $redirector_;
    int C;
    public StringBuilder D;
    private TextPaint E;

    /* renamed from: d, reason: collision with root package name */
    int f252307d;

    /* renamed from: e, reason: collision with root package name */
    TextView f252308e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<MutualMarkIconItemView> f252309f;

    /* renamed from: h, reason: collision with root package name */
    int f252310h;

    /* renamed from: i, reason: collision with root package name */
    int f252311i;

    /* renamed from: m, reason: collision with root package name */
    int f252312m;

    public MutualMarkIconsView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void a() {
        ArrayList<MutualMarkIconItemView> arrayList = this.f252309f;
        int i3 = 0;
        if (arrayList != null) {
            Iterator<MutualMarkIconItemView> it = arrayList.iterator();
            while (it.hasNext()) {
                MutualMarkIconItemView next = it.next();
                if (next != null && next.getVisibility() == 0) {
                    i3 += next.b();
                }
            }
        }
        this.C = i3;
    }

    private void b() {
        removeAllViews();
        setVisibility(8);
        this.C = 0;
        this.f252308e = null;
        ArrayList<MutualMarkIconItemView> arrayList = this.f252309f;
        if (arrayList != null) {
            Iterator<MutualMarkIconItemView> it = arrayList.iterator();
            while (it.hasNext()) {
                MutualMarkIconItemView next = it.next();
                if (next != null) {
                    next.a();
                }
            }
        }
        this.f252309f = null;
    }

    private int c(CharSequence charSequence, float f16) {
        if (TextUtils.isEmpty(charSequence)) {
            return 0;
        }
        this.E.setTextSize(f16);
        return (int) Math.ceil(Layout.getDesiredWidth(charSequence, this.E));
    }

    private boolean g(int i3, int i16, String str) {
        MutualMarkIconItemView mutualMarkIconItemView = this.f252309f.get(i16);
        if (mutualMarkIconItemView != null && mutualMarkIconItemView.getVisibility() == 0) {
            this.C -= mutualMarkIconItemView.b();
            mutualMarkIconItemView.setVisibility(8);
            if (this.C <= i3) {
                return true;
            }
            return false;
        }
        return false;
    }

    private void h(QQAppInterface qQAppInterface, String str, long j3) {
        View view;
        int i3;
        int i16;
        boolean z16 = false;
        if (j3 > 0 && ((i3 = this.f252307d) == 3 || i3 == 4 || i3 == 2)) {
            if (i3 != 3 && i3 != 4) {
                i16 = 1;
            } else {
                i16 = 0;
            }
            FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
            if (friendsManager != null && friendsManager.b0(i16)) {
                if (this.f252308e == null) {
                    int i17 = this.f252307d;
                    if (i17 != 3 && i17 != 4) {
                        BaselineTextView baselineTextView = new BaselineTextView(getContext(), null);
                        this.f252308e = baselineTextView;
                        baselineTextView.setTextColor(getResources().getColorStateList(R.color.skin_black));
                        this.f252308e.setSingleLine();
                        this.f252308e.setTextSize(1, 14.0f);
                        this.f252308e.setPadding(0, 0, 0, BaseAIOUtils.f(2.0f, getResources()));
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 80;
                        addView(this.f252308e, layoutParams);
                    } else {
                        TextView textView = new TextView(getContext());
                        this.f252308e = textView;
                        textView.setTextSize(1, 12.0f);
                        if (this.f252307d == 4) {
                            this.f252308e.setTextColor(getResources().getColorStateList(R.color.skin_black));
                        } else {
                            this.f252308e.setTextColor(getResources().getColorStateList(R.color.skin_gray2_theme_version2));
                        }
                        this.f252308e.setSingleLine();
                        this.f252308e.setGravity(16);
                        addView(this.f252308e, new LinearLayout.LayoutParams(-2, this.f252310h));
                    }
                }
                if (j3 > AppConstants.LBS_HELLO_UIN_LONGVALUE) {
                    j3 = 9999;
                }
                this.f252308e.setText(j3 + HardCodeUtil.qqStr(R.string.oct));
                if (AppSetting.f99565y) {
                    String format = String.format(a.d(getContext(), 19), Long.valueOf(j3));
                    this.f252308e.setContentDescription(format);
                    StringBuilder sb5 = this.D;
                    if (sb5 != null) {
                        sb5.append(format);
                    }
                }
                int measuredWidth = this.f252308e.getMeasuredWidth();
                if (measuredWidth <= 0) {
                    measuredWidth = BaseAIOUtils.f(32.0f, getResources());
                }
                this.C += measuredWidth;
                z16 = true;
            }
        }
        if (!z16 && (view = this.f252308e) != null) {
            removeView(view);
            this.f252308e = null;
        }
    }

    private void i(QQAppInterface qQAppInterface, String str, c cVar, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, MutualMarkIconItemView mutualMarkIconItemView) {
        if (cVar.c()) {
            mutualMarkIconItemView.setIconResource(cVar);
            boolean z16 = false;
            mutualMarkIconItemView.setVisibility(0);
            if (AppSetting.f99565y) {
                String str2 = cVar.f252099o;
                if (!TextUtils.isEmpty(cVar.f252104t)) {
                    str2 = cVar.f252104t;
                }
                mutualMarkIconItemView.setContentDescription(str2);
                StringBuilder sb5 = this.D;
                if (sb5 != null) {
                    sb5.append(str2);
                }
            }
            if (cVar.e() && this.f252307d == 3 && !cVar.f252094j) {
                if (cVar.f252095k != 0 && System.currentTimeMillis() - cVar.f252095k > 3500) {
                    cVar.f252094j = true;
                    if (aVar != null) {
                        com.tencent.mobileqq.mutualmark.c.a(cVar, aVar);
                        a.a(aVar);
                    }
                } else {
                    cVar.f252095k = System.currentTimeMillis();
                    if (aVar != null) {
                        com.tencent.mobileqq.mutualmark.c.a(cVar, aVar);
                    }
                    mutualMarkIconItemView.f(str);
                    z16 = true;
                }
            }
            if (!z16) {
                mutualMarkIconItemView.setIconAlpha(cVar.a());
            }
            this.C += mutualMarkIconItemView.b();
            return;
        }
        mutualMarkIconItemView.setVisibility(8);
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.C;
    }

    public int e(LinearLayout linearLayout, BuddyListFriends.a aVar, int i3) {
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, linearLayout, aVar, Integer.valueOf(i3))).intValue();
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.K.getLayoutParams();
        if (layoutParams != null) {
            i16 = layoutParams.rightMargin;
        } else {
            i16 = 0;
        }
        a();
        int i18 = this.C + i3 + i16;
        if (i18 <= this.f252311i) {
            return i18;
        }
        int measuredWidth = linearLayout.getMeasuredWidth();
        if (measuredWidth <= this.f252311i) {
            return this.C + i3 + i16;
        }
        int paddingLeft = measuredWidth - (linearLayout.getPaddingLeft() + linearLayout.getPaddingRight());
        int min = Math.min(getResources().getDimensionPixelSize(R.dimen.b5z), c(aVar.f181511h.getText(), aVar.f181511h.getTextSize()));
        int compoundPaddingLeft = aVar.f181511h.getCompoundPaddingLeft() + aVar.f181511h.getCompoundPaddingRight() + aVar.f181511h.getPaddingRight() + aVar.f181511h.getPaddingLeft();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) aVar.H.getLayoutParams();
        if (layoutParams2 != null) {
            i17 = layoutParams2.leftMargin;
        } else {
            i17 = 0;
        }
        int measuredWidth2 = aVar.I.getMeasuredWidth();
        int i19 = ((((paddingLeft - i17) - min) - compoundPaddingLeft) - measuredWidth2) - i16;
        if (QLog.isColorLevel()) {
            QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInFriendItemLayout after maxMutualMarkWidth:" + i19 + " rootWidth:" + paddingLeft + " nickRootLeft:" + i17 + " nickMinWidth:" + min + " nickExtraWidth:" + compoundPaddingLeft + " ivKingIconWidth:" + measuredWidth2 + " mutualMarkMarginRight:" + i16 + "maybeWidth " + this.C);
        }
        if (this.C > i19) {
            if (this.f252309f != null) {
                if (((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isElegantVersion()) {
                    for (int size = this.f252309f.size() - 1; size >= 0 && !g(i19, size, "getMaybeWidthInFriendItemLayout hide Type:"); size--) {
                    }
                } else {
                    for (int i26 = 0; i26 < this.f252309f.size() && !g(i19, i26, "getMaybeWidthInFriendItemLayout hide Type:"); i26++) {
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInFriendItemLayout after maybeWidth:" + this.C);
            }
        }
        return this.C + i16;
    }

    public int f(View view, SpecailCareListActivity.y yVar, int i3, int i16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, view, yVar, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) yVar.f186546o.getLayoutParams();
        if (layoutParams != null) {
            i17 = layoutParams.rightMargin;
        } else {
            i17 = 0;
        }
        a();
        int i18 = this.C;
        if (i18 <= this.f252312m) {
            return i18 + i3 + i17;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (measuredWidth > 0) {
            i16 = measuredWidth;
        }
        if (i16 <= this.f252312m) {
            return this.C + i3 + i17;
        }
        int paddingLeft = i16 - (view.getPaddingLeft() + view.getPaddingRight());
        int min = Math.min(getResources().getDimensionPixelSize(R.dimen.b5z), c(yVar.f186535d.getText(), yVar.f186535d.getTextSize()));
        int compoundPaddingLeft = yVar.f186535d.getCompoundPaddingLeft() + yVar.f186535d.getCompoundPaddingRight() + yVar.f186535d.getPaddingRight() + yVar.f186535d.getPaddingLeft();
        int f16 = BaseAIOUtils.f(72.0f, getResources());
        int i19 = (((paddingLeft - f16) - i17) - min) - compoundPaddingLeft;
        if (QLog.isColorLevel()) {
            QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInSpecialCareList maxMutualMarkWidth:" + i19 + " maybeWidth:" + this.C + " nickMinWidth:" + min + " nickRootLeft:" + f16 + " mutualMarkMarginRight:" + i17);
        }
        if (this.C > i19) {
            if (this.f252309f != null) {
                for (int i26 = 0; i26 < this.f252309f.size(); i26++) {
                    MutualMarkIconItemView mutualMarkIconItemView = this.f252309f.get(i26);
                    if (mutualMarkIconItemView != null && mutualMarkIconItemView.getVisibility() == 0) {
                        this.C -= mutualMarkIconItemView.b();
                        mutualMarkIconItemView.setVisibility(8);
                        if (QLog.isColorLevel()) {
                            QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInSpecialCareList hide Type:" + mutualMarkIconItemView.c() + " width:" + mutualMarkIconItemView.b());
                        }
                        if (this.C <= i19) {
                            break;
                        }
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInSpecialCareList after maybeWidth:" + this.C);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInSpecialCareList return:" + this.C);
        }
        return this.C + i17;
    }

    public void j(QQAppInterface qQAppInterface, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qQAppInterface, str, Integer.valueOf(i3));
        } else {
            k(qQAppInterface, str, i3, false);
        }
    }

    public void k(QQAppInterface qQAppInterface, String str, int i3, boolean z16) {
        ArrayList<c> d16;
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar;
        int parseInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, qQAppInterface, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (AppSetting.f99565y) {
            this.D = new StringBuilder();
        }
        this.f252307d = i3;
        if (z16) {
            d16 = com.tencent.mobileqq.mutualmark.c.k(qQAppInterface, str, i3);
        } else {
            d16 = com.tencent.mobileqq.mutualmark.c.d(qQAppInterface, str, false, i3);
        }
        if (d16 != null && !d16.isEmpty()) {
            if (this.f252309f == null) {
                this.f252309f = new ArrayList<>();
            }
            String d17 = com.tencent.relation.common.config.toggle.c.O.d("friend_list", "999");
            if (!TextUtils.isEmpty(d17) && !d17.equals("999") && d16.size() >= (parseInt = Integer.parseInt(d17))) {
                d16 = new ArrayList<>(d16.subList(0, parseInt));
            }
            int size = this.f252309f.size();
            int size2 = d16.size();
            if (size < size2) {
                while (size < size2) {
                    MutualMarkIconItemView mutualMarkIconItemView = new MutualMarkIconItemView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.f252310h);
                    layoutParams.rightMargin = BaseAIOUtils.f(4.0f, getResources());
                    addView(mutualMarkIconItemView, size, layoutParams);
                    this.f252309f.add(mutualMarkIconItemView);
                    size++;
                }
            } else if (size > size2) {
                for (int i16 = size - 1; i16 >= size2; i16--) {
                    removeView(this.f252309f.remove(i16));
                }
            }
            setVisibility(0);
            this.C = 0;
            com.tencent.qqnt.ntrelation.intimateinfo.bean.a intimateSimpleInfoWithUid = ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).getIntimateSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "MutualMarkIconsView");
            if (intimateSimpleInfoWithUid == null) {
                return;
            }
            long j3 = 0;
            for (int i17 = 0; i17 < d16.size(); i17++) {
                c cVar = d16.get(i17);
                MutualMarkIconItemView mutualMarkIconItemView2 = this.f252309f.get(i17);
                if (z16) {
                    aVar = null;
                } else {
                    aVar = intimateSimpleInfoWithUid;
                }
                i(qQAppInterface, str, cVar, aVar, mutualMarkIconItemView2);
                if (cVar.f252085a == 5) {
                    j3 = cVar.f252088d;
                }
            }
            h(qQAppInterface, str, j3);
            return;
        }
        b();
    }

    public MutualMarkIconsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public MutualMarkIconsView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f252307d = 0;
        this.f252310h = 42;
        this.f252311i = 294;
        this.f252312m = 294;
        this.C = 0;
        this.E = new TextPaint();
        this.f252310h = BaseAIOUtils.f(16.0f, getResources());
        int f16 = BaseAIOUtils.f(140.0f, getResources());
        this.f252311i = f16;
        this.f252312m = f16;
    }
}

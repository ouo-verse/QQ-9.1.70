package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.j;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.nowsummarycard.NowSummaryCard$MiniCard;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.widget.IRecentImgv;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h extends j {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public static int f185615g;

    /* renamed from: f, reason: collision with root package name */
    private List<String> f185616f;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a extends j.a {
        static IPatchRedirector $redirector_;
        public TextView C;
        public TextView D;
        public TextView E;
        public View F;
        public TextView G;

        /* renamed from: d, reason: collision with root package name */
        public ThemeImageView f185617d;

        /* renamed from: e, reason: collision with root package name */
        public DragTextView f185618e;

        /* renamed from: f, reason: collision with root package name */
        public TextView f185619f;

        /* renamed from: h, reason: collision with root package name */
        public ImageView f185620h;

        /* renamed from: i, reason: collision with root package name */
        public TextView f185621i;

        /* renamed from: m, reason: collision with root package name */
        public ImageView f185622m;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void i(int i3, TextView textView, View... viewArr) {
        boolean z16;
        int i16;
        int width;
        if (viewArr != null && i3 > 0) {
            int length = viewArr.length;
            boolean z17 = false;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                if (i17 < length) {
                    View view = viewArr[i17];
                    if (view.getVisibility() != 8) {
                        if (view instanceof TextView) {
                            TextView textView2 = (TextView) view;
                            String charSequence = textView2.getText().toString();
                            if (!TextUtils.isEmpty(charSequence)) {
                                i18 = (int) (i18 + textView2.getPaint().measureText(charSequence) + 0.5f);
                            }
                            i18 += view.getPaddingLeft();
                            width = view.getPaddingRight();
                        } else {
                            width = view.getWidth();
                        }
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                        i18 = i18 + width + layoutParams.leftMargin + layoutParams.rightMargin;
                        if (i18 > i3) {
                            z16 = false;
                            break;
                        }
                    }
                    i17++;
                } else {
                    z16 = true;
                    break;
                }
            }
            if (i18 == 0) {
                return;
            }
            if (z16) {
                String charSequence2 = textView.getText().toString();
                if (!TextUtils.isEmpty(charSequence2)) {
                    i16 = (int) (textView.getPaint().measureText(charSequence2) + 0.5f);
                } else {
                    i16 = 0;
                }
                if (i16 + i18 < i3) {
                    z17 = true;
                }
                z16 = z17;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView.getLayoutParams();
            if (z16) {
                layoutParams2.weight = 0.0f;
            } else {
                layoutParams2.weight = 1.0f;
            }
        }
    }

    private int k(View view) {
        int i3 = view.getResources().getDisplayMetrics().widthPixels;
        int paddingRight = view.getPaddingRight() + 0 + view.getPaddingLeft();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        return i3 - ((paddingRight + layoutParams.leftMargin) + layoutParams.rightMargin);
    }

    private void l(RecentBaseData recentBaseData, a aVar) {
        CharSequence charSequence = recentBaseData.mMsgExtroInfo;
        CharSequence text = aVar.D.getText();
        int currentTextColor = aVar.D.getCurrentTextColor();
        if (charSequence == null) {
            charSequence = "";
        }
        if (!charSequence.equals(text)) {
            aVar.D.setText(charSequence);
        }
        int i3 = recentBaseData.mExtraInfoColor;
        if (currentTextColor != i3 && i3 != 0) {
            aVar.D.setTextColor(i3);
        }
    }

    private void m(RecentBaseData recentBaseData, a aVar) {
        CharSequence charSequence = recentBaseData.mLastMsg;
        CharSequence text = aVar.E.getText();
        if (charSequence == null) {
            charSequence = "";
        }
        if (!charSequence.equals(text)) {
            try {
                aVar.E.setText(charSequence);
            } catch (Exception e16) {
                e16.printStackTrace();
                aVar.E.setText(((Object) charSequence) + " ");
            }
        }
    }

    private void n(RecentBaseData recentBaseData, a aVar) {
        String str = recentBaseData.mShowTime;
        CharSequence text = aVar.f185619f.getText();
        if (str == null) {
            str = "";
        }
        if (!str.equals(text)) {
            aVar.f185619f.setText(str);
        }
    }

    private void p(RecentBaseData recentBaseData, a aVar) {
        if ((recentBaseData.mMenuFlag & 240) == 32) {
            aVar.leftView.setBackgroundResource(R.drawable.f160541jn);
        } else {
            aVar.leftView.setBackgroundResource(R.drawable.f160540jm);
        }
    }

    private void q(View view, RecentBaseData recentBaseData, Context context, a aVar) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19 = recentBaseData.mUnreadNum;
        int i26 = recentBaseData.mUnreadFlag;
        if (i19 > 0) {
            if (i26 == 0) {
                aVar.f185618e.setDragViewType(-1, view);
            } else {
                if (i26 == 2) {
                    aVar.f185618e.setDragViewType(-1, view);
                    i3 = 1;
                    i16 = 0;
                    i17 = i16;
                    com.tencent.widget.d.c(aVar.f185618e, i3, i16, i17, 99, null);
                }
                i3 = 3;
                if (i26 == 3) {
                    ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(QCommonOnlineExpProviderImpl.EXP_QQ_MESSAGE_REMINDER_DND);
                    expEntity.reportExpExposure();
                    if (expEntity.isExperiment()) {
                        i3 = 11;
                        i18 = R.drawable.skin_tips_newmessage_gray_small;
                        i19 = 0;
                    } else {
                        aVar.f185618e.setTextColor(context.getResources().getColor(R.color.skin_qq_conversation_unread_gray_text_color));
                        i18 = R.drawable.skin_tips_newmessage_gray;
                    }
                    aVar.f185618e.setDragViewType(10, view);
                    i17 = i18;
                } else {
                    aVar.f185618e.setDragViewType(0, view);
                    aVar.f185618e.setTextColor(context.getResources().getColor(R.color.skin_qq_conversation_unread_red_text_color));
                    i17 = R.drawable.skin_tips_newmessage;
                }
                i16 = i19;
                com.tencent.widget.d.c(aVar.f185618e, i3, i16, i17, 99, null);
            }
        }
        i3 = 0;
        i16 = 0;
        i17 = i16;
        com.tencent.widget.d.c(aVar.f185618e, i3, i16, i17, 99, null);
    }

    private void r(RecentBaseData recentBaseData, Context context, a aVar) {
        if (u92.e.a(recentBaseData.getRecentUserUin())) {
            ((IImageLoader) QRoute.api(IImageLoader.class)).displayImage(aVar.f185617d, ((NowSummaryCard$MiniCard) u92.e.b(recentBaseData.getRecentUserUin())).logo.get(), context.getResources().getDrawable(R.drawable.exy), context.getResources().getDrawable(R.drawable.exy), null, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.CharSequence] */
    @Override // com.tencent.mobileqq.activity.recent.j
    public void a(View view, RecentBaseData recentBaseData, Context context, Drawable drawable) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, recentBaseData, context, drawable);
            return;
        }
        if (view != null && recentBaseData != null) {
            Object tag = view.getTag();
            if (tag instanceof a) {
                aVar = (a) tag;
            } else {
                aVar = null;
            }
            if (aVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + tag);
                    return;
                }
                return;
            }
            aVar.f185617d.setImageDrawable(drawable);
            String str = recentBaseData.mTitleName;
            CharSequence text = aVar.f185621i.getText();
            String str2 = "";
            if (str == null) {
                str = "";
            }
            if (aVar.f185621i != null && !str.equals(text)) {
                aVar.f185621i.setText(str);
            }
            if (String.valueOf(AppConstants.MSG_BOX_MYMOMMENT_LONGVALUE).equals(recentBaseData.getRecentUserUin())) {
                aVar.f185621i.setText(str);
            }
            r(recentBaseData, context, aVar);
            int i3 = recentBaseData.mAuthenIconId;
            if (i3 > 0) {
                aVar.f185622m.setVisibility(0);
                aVar.f185622m.setImageResource(i3);
            } else {
                aVar.f185622m.setVisibility(8);
            }
            ?? r122 = recentBaseData.mExtraInfo;
            CharSequence text2 = aVar.C.getText();
            if (r122 != 0) {
                str2 = r122;
            }
            if (TextUtils.isEmpty(str2)) {
                aVar.C.setVisibility(8);
            } else {
                if (!str2.equals(text2)) {
                    aVar.C.setText(str2);
                }
                aVar.C.setVisibility(0);
            }
            i(k((View) aVar.f185621i.getParent()), aVar.f185621i, aVar.f185622m, aVar.C);
            l(recentBaseData, aVar);
            m(recentBaseData, aVar);
            n(recentBaseData, aVar);
            o(aVar, recentBaseData);
            q(view, recentBaseData, context, aVar);
            if (aVar.f185619f.getVisibility() != 0) {
                aVar.f185619f.setVisibility(0);
            }
            if (AppSetting.f99565y) {
                view.setContentDescription(recentBaseData.mContentDesc);
            }
            p(recentBaseData, aVar);
            long faceExtraFlag = recentBaseData.getFaceExtraFlag();
            KeyEvent.Callback callback = aVar.f185617d;
            if (callback instanceof IRecentImgv) {
                ((IRecentImgv) callback).showTroopCreditStatus(faceExtraFlag);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.recent", 2, "bindView|param invalidate");
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.j
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.activity.recent.j
    public List<String> e(RecentBaseData recentBaseData, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) recentBaseData, (Object) context);
        }
        if (recentBaseData != null && context != null) {
            int i3 = recentBaseData.mMenuFlag;
            Resources resources = context.getResources();
            List<String> list = this.f185616f;
            if (list == null) {
                this.f185616f = new ArrayList();
            } else {
                list.clear();
            }
            int i16 = 983040 & i3;
            if (i16 == 131072) {
                this.f185616f.add(resources.getString(j.f185633c[5]));
            } else if (i16 == 65536) {
                this.f185616f.add(resources.getString(j.f185633c[4]));
            }
            int i17 = i3 & 240;
            if (i17 == 32) {
                this.f185616f.add(resources.getString(j.f185633c[2]));
            } else if (i17 == 16) {
                this.f185616f.add(resources.getString(j.f185633c[3]));
            }
            if ((i3 & 15) == 1) {
                this.f185616f.add(resources.getString(j.f185633c[0]));
            }
            return this.f185616f;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.recent.j
    public View f(int i3, Object obj, i iVar, View view, ViewGroup viewGroup, Context context, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, DragFrameLayout.b bVar) {
        a aVar;
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), obj, iVar, view, viewGroup, context, onClickListener, onLongClickListener, bVar);
        }
        Drawable drawable = null;
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            aVar = new a();
            view2 = c(context, R.layout.hmo, aVar);
            ThemeImageView themeImageView = (ThemeImageView) view2.findViewById(R.id.icon);
            aVar.f185617d = themeImageView;
            themeImageView.setSupportMaskView(true);
            aVar.f185618e = (DragTextView) view2.findViewById(R.id.unreadmsg);
            aVar.f185619f = (TextView) view2.findViewById(R.id.lastMsgTime);
            aVar.f185620h = (ImageView) view2.findViewById(R.id.f164916ba2);
            aVar.f185621i = (TextView) view2.findViewById(android.R.id.text1);
            aVar.f185622m = (ImageView) view2.findViewById(R.id.j1x);
            aVar.C = (TextView) view2.findViewById(R.id.cwu);
            aVar.D = (TextView) view2.findViewById(R.id.c0i);
            TextView textView = (TextView) view2.findViewById(android.R.id.text2);
            aVar.E = textView;
            textView.setGravity(16);
            aVar.F = view2.findViewById(R.id.zol);
            aVar.G = (TextView) view2.findViewById(R.id.vfp);
            j(view2, aVar.f185619f, context);
            view2.setTag(aVar);
            RecentAdapter recentAdapter = this.f185636a;
            if (recentAdapter != null) {
                aVar.f185618e.setOnModeChangeListener(recentAdapter.j());
            }
        } else {
            view2 = view;
        }
        aVar.f185618e.setTag(Integer.valueOf(i3));
        if (AppSetting.f99565y) {
            view2.setContentDescription(null);
        }
        if (obj instanceof RecentBaseData) {
            RecentBaseData recentBaseData = (RecentBaseData) obj;
            if (iVar != null) {
                drawable = iVar.g(recentBaseData);
            }
            a(view2, recentBaseData, context, drawable);
            if (obj instanceof RecentItemEcShop) {
                aVar.f185617d.setOnClickListener(onClickListener);
                aVar.f185617d.setTag(-1, Integer.valueOf(i3));
                if (AppSetting.f99565y) {
                    aVar.f185617d.setContentDescription(String.format(HardCodeUtil.qqStr(R.string.stt), ((RecentItemEcShop) obj).getTitleName()));
                }
            }
        } else {
            aVar.f185621i.setText("");
            aVar.f185622m.setVisibility(8);
            aVar.C.setVisibility(8);
            aVar.C.setText("");
            aVar.D.setText("");
            aVar.E.setText("");
            aVar.f185619f.setText("");
            aVar.f185620h.setImageDrawable(null);
        }
        h(context, view2, i3, obj, aVar, onClickListener);
        view2.setOnClickListener(onClickListener);
        view2.setOnLongClickListener(onLongClickListener);
        view2.setTag(-1, Integer.valueOf(i3));
        return view2;
    }

    protected void j(View view, TextView textView, Context context) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, view, textView, context);
            return;
        }
        try {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.text1Area);
            String d16 = o.c().d("000000", 1225168973512L);
            if (TextUtils.isEmpty(d16)) {
                d16 = o.c().b();
            }
            if (!TextUtils.isEmpty(d16) && d16.length() != 10) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (f185615g <= 0 || z16) {
                float f16 = context.getResources().getDisplayMetrics().density;
                TextPaint paint = textView.getPaint();
                if (paint == null) {
                    paint = new TextPaint();
                    paint.setTextSize(12.0f * f16);
                }
                if (z16) {
                    float f17 = f16 * 6.0f;
                    int measureText = (int) (paint.measureText(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT) + f17);
                    int measureText2 = (int) (paint.measureText(d16) + f17);
                    if (measureText2 > measureText) {
                        f185615g = measureText2;
                    } else {
                        f185615g = measureText;
                    }
                } else {
                    f185615g = (int) (paint.measureText(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT) + (f16 * 6.0f));
                }
            }
            if (linearLayout.getPaddingRight() < f185615g) {
                linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), f185615g, linearLayout.getPaddingBottom());
            }
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.i("RecentDefaultItemBuilder", 4, e16.toString());
            }
        }
    }

    public void o(a aVar, RecentBaseData recentBaseData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar, (Object) recentBaseData);
            return;
        }
        int i3 = recentBaseData.mStatus;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            aVar.f185620h.setVisibility(8);
                            aVar.f185620h.setImageDrawable(null);
                            return;
                        } else {
                            aVar.f185620h.setVisibility(0);
                            aVar.f185620h.setImageResource(R.drawable.qui_telephone_filled_feedback_success);
                            return;
                        }
                    }
                    aVar.f185620h.setVisibility(0);
                    aVar.f185620h.setImageResource(R.drawable.conversation_unsend_icon);
                    return;
                }
                aVar.f185620h.setVisibility(0);
                if (recentBaseData.mIsGroupVideo) {
                    aVar.f185620h.setImageResource(R.drawable.qui_video_on_filled_feedback_success);
                    return;
                } else {
                    aVar.f185620h.setImageResource(R.drawable.qui_telephone_filled_feedback_success);
                    return;
                }
            }
            aVar.f185620h.setVisibility(0);
            if (recentBaseData.mIsGroupVideo) {
                aVar.f185620h.setImageResource(R.drawable.qui_video_on_filled_feedback_success);
                return;
            } else {
                aVar.f185620h.setImageResource(R.drawable.qui_telephone_filled_feedback_success);
                return;
            }
        }
        aVar.f185620h.setVisibility(0);
        aVar.f185620h.setImageResource(R.drawable.qui_telephone_filled_feedback_success);
    }
}

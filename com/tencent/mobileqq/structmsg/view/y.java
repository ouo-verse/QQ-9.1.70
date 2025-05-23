package com.tencent.mobileqq.structmsg.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.structmsg.widget.TextViewWrapLayout;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class y extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;
    public boolean X0;

    public y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.X0 = false;
        }
    }

    @TargetApi(16)
    private RelativeLayout E(Context context, boolean z16) {
        int i3;
        int i16;
        int f16;
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        B(relativeLayout);
        D(relativeLayout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (z16) {
            i3 = R.dimen.f158263bo;
        } else {
            i3 = R.dimen.axy;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(i3);
        if (z16) {
            i16 = R.dimen.f158264bp;
        } else {
            i16 = R.dimen.axz;
        }
        int dimensionPixelSize2 = resources.getDimensionPixelSize(i16);
        if (h(1)) {
            f16 = BaseAIOUtils.f(15.0f, resources);
        } else {
            f16 = BaseAIOUtils.f(6.0f, resources);
        }
        int f17 = BaseAIOUtils.f(6.0f, resources);
        if (h(2)) {
            f17 = BaseAIOUtils.f(15.0f, resources);
        } else if (h(1)) {
            f17 = BaseAIOUtils.f(15.0f, resources);
        }
        relativeLayout.setPadding(dimensionPixelSize, f16, dimensionPixelSize2, f17);
        relativeLayout.setLayoutParams(layoutParams);
        return relativeLayout;
    }

    private RelativeLayout F(Context context, String str, String str2, String str3) {
        URLDrawable uRLDrawable;
        Resources resources = context.getResources();
        TextViewWrapLayout textViewWrapLayout = new TextViewWrapLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        int f16 = BaseAIOUtils.f(15.0f, resources);
        textViewWrapLayout.setLayoutParams(layoutParams);
        textViewWrapLayout.setPadding(0, f16, 0, f16);
        AnyScaleTypeImageView anyScaleTypeImageView = new AnyScaleTypeImageView(context);
        anyScaleTypeImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = BaseAIOUtils.f(70.0f, resources);
            obtain.mRequestHeight = BaseAIOUtils.f(70.0f, resources);
            uRLDrawable = URLDrawable.getDrawable(str, obtain);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("StructMsgItemLayout5", 2, "getPAVideoPreDialogView():  getDrawable Exception, imgUrl=" + str, e16);
            }
            uRLDrawable = null;
        }
        anyScaleTypeImageView.setId(R.id.image);
        anyScaleTypeImageView.setImageDrawable(uRLDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(BaseAIOUtils.f(70.0f, resources), BaseAIOUtils.f(70.0f, resources));
        layoutParams2.addRule(9);
        layoutParams2.addRule(10);
        textViewWrapLayout.addView(anyScaleTypeImageView, layoutParams2);
        int f17 = BaseAIOUtils.f(10.0f, resources);
        TextView textView = new TextView(context);
        textView.setId(R.id.kbs);
        textView.setText(str2);
        textView.setTextSize(14.0f);
        textView.setTextColor(-8355712);
        textView.setTypeface(Typeface.DEFAULT);
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = 0;
        layoutParams3.leftMargin = f17;
        layoutParams3.addRule(10);
        layoutParams3.addRule(1, anyScaleTypeImageView.getId());
        layoutParams3.addRule(11);
        TextView textView2 = new TextView(context);
        textView2.setId(R.id.tv_summary);
        textView2.setText(str3);
        textView2.setTextSize(14.0f);
        textView2.setTextColor(-8355712);
        textView2.setTypeface(Typeface.DEFAULT);
        textView2.setMaxLines(2);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = 0;
        layoutParams4.leftMargin = f17;
        layoutParams4.addRule(3, textView.getId());
        layoutParams4.addRule(1, anyScaleTypeImageView.getId());
        textViewWrapLayout.addView(textView, layoutParams3);
        textViewWrapLayout.addView(textView2, layoutParams4);
        textViewWrapLayout.a(true);
        return textViewWrapLayout;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 5;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "Layout5";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        Bundle bundle2;
        boolean z16;
        RelativeLayout E;
        TextView textView;
        Object tag;
        int i3;
        int dimensionPixelSize;
        String str;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, this, context, view, bundle);
        }
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = bundle;
        }
        if (bundle2.getBoolean("pre_dialog")) {
            Iterator<AbsStructMsgElement> it = this.U0.iterator();
            String str2 = null;
            String str3 = null;
            String str4 = null;
            boolean z17 = false;
            while (it.hasNext()) {
                AbsStructMsgElement next = it.next();
                if (next instanceof StructMsgItemVideo) {
                    StructMsgItemVideo structMsgItemVideo = (StructMsgItemVideo) next;
                    if (!structMsgItemVideo.v()) {
                        break;
                    }
                    str2 = structMsgItemVideo.R0;
                    str3 = structMsgItemVideo.Y0;
                    z17 = true;
                } else if (next instanceof StructMsgItemTitle) {
                    str4 = ((StructMsgItemTitle) next).t();
                }
            }
            if (z17) {
                return F(context, str2, str4, str3);
            }
        }
        Resources resources = context.getResources();
        String str5 = "accostType";
        if (bundle2.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (view != null && (view instanceof RelativeLayout)) {
            E = (RelativeLayout) view;
        } else {
            E = E(context, z16);
        }
        E.removeAllViews();
        int applyDimension = (int) (TypedValue.applyDimension(1, 175.0f, resources.getDisplayMetrics()) + 0.5f);
        Iterator<AbsStructMsgElement> it5 = this.U0.iterator();
        String str6 = "";
        View view2 = null;
        boolean z18 = false;
        int i18 = -1;
        TextView textView2 = null;
        while (it5.hasNext()) {
            AbsStructMsgElement next2 = it5.next();
            next2.O0 = this.O0;
            String str7 = next2.f290322e;
            if ("title".equals(str7)) {
                StructMsgItemTitle structMsgItemTitle = (StructMsgItemTitle) next2;
                if (!TextUtils.isEmpty(structMsgItemTitle.t())) {
                    TextView textView3 = new TextView(context);
                    textView3.setText(structMsgItemTitle.t());
                    str6 = structMsgItemTitle.t();
                    textView3.setId(R.id.kbs);
                    textView3.setTag(structMsgItemTitle);
                    textView3.setGravity(3);
                    textView3.setGravity(16);
                    if (bundle2.getInt(str5) == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {
                        textView3.setMaxLines(2);
                    } else {
                        textView3.setMaxLines(1);
                    }
                    textView3.setEllipsize(TextUtils.TruncateAt.END);
                    textView3.setTextColor(-1);
                    textView3.setTextSize(2, 18.0f);
                    textView3.setBackgroundColor(context.getResources().getColor(R.color.f156730ad));
                    int f16 = BaseAIOUtils.f(10.0f, resources);
                    int f17 = BaseAIOUtils.f(4.0f, resources);
                    int f18 = BaseAIOUtils.f(5.0f, resources);
                    str = str5;
                    if (bundle2.getBoolean("pre_dialog", false)) {
                        i17 = f16 * 2;
                    } else {
                        i17 = f16;
                    }
                    textView3.setPadding(i17, f17, f16, f18);
                    textView2 = textView3;
                } else {
                    str = str5;
                }
            } else {
                str = str5;
                if ("picture".equals(str7)) {
                    view2 = next2.c(context, null, bundle2);
                    View findViewById = view2.findViewById(R.id.dgb);
                    if (findViewById != null && (findViewById instanceof AnyScaleTypeImageView)) {
                        ((AnyScaleTypeImageView) findViewById).setTag(R.id.g4h, 1);
                    }
                } else if ("video".equals(str7)) {
                    if (next2 instanceof StructMsgItemVideo) {
                        StructMsgItemVideo structMsgItemVideo2 = (StructMsgItemVideo) next2;
                        if (this.X0) {
                            structMsgItemVideo2.f290502q1 = false;
                        }
                        if (structMsgItemVideo2.v()) {
                            if (!this.P0.hasFlag(4)) {
                                i16 = -2;
                            } else {
                                i16 = -1;
                            }
                            int i19 = 0;
                            while (true) {
                                if (i19 >= this.U0.size()) {
                                    break;
                                }
                                AbsStructMsgElement absStructMsgElement = this.U0.get(i19);
                                if ("title".equals(absStructMsgElement.f290322e)) {
                                    bundle2.putString("public_account_video_title", ((StructMsgItemTitle) absStructMsgElement).t());
                                    break;
                                }
                                i19++;
                            }
                        } else {
                            bundle2.putBoolean("v_crap_ctn", true);
                            bundle2.putBoolean("has_cnr", true);
                            bundle2.putInt(QCircleSchemeAttr.Detail.V_HEIGHT, applyDimension);
                            i16 = -2;
                        }
                    } else {
                        i16 = -1;
                    }
                    E.setPadding(0, 0, 0, 0);
                    E.getLayoutParams().width = i16;
                    if (bundle2.getBoolean("pre_dialog", false)) {
                        ((LinearLayout.LayoutParams) E.getLayoutParams()).gravity = 1;
                    }
                    view2 = next2.c(context, null, bundle2);
                    i18 = i16;
                    z18 = true;
                    str5 = str;
                }
            }
            str5 = str;
        }
        if (view2 != null) {
            if (!z18) {
                if (z16) {
                    dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f158263bo);
                } else {
                    dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.axy);
                }
                int i26 = dimensionPixelSize * 2;
                int i27 = BaseChatItemLayout.f178058p0 - i26;
                if (!bundle2.getBoolean("hasHeadIcon", true)) {
                    i3 = BaseChatItemLayout.f178058p0 - i26;
                } else {
                    i3 = i27;
                }
                applyDimension = (int) (i3 / 1.8f);
            } else {
                i3 = i18;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, applyDimension);
            if (z18) {
                layoutParams = new RelativeLayout.LayoutParams(i3, -2);
            }
            E.addView(view2, layoutParams);
        }
        if (z18 && !TextUtils.isEmpty(str6) && (view2 instanceof TitledImageView)) {
            TitledImageView titledImageView = (TitledImageView) view2;
            titledImageView.setTitle(str6);
            titledImageView.setTextColor(-1);
            titledImageView.setTextSize(com.tencent.mobileqq.activity.aio.l.X(2, 18, resources));
            titledImageView.setTextBackground(context.getResources().getColor(R.color.f156730ad));
            titledImageView.setTextPadding(BaseAIOUtils.f(10.0f, resources));
            titledImageView.settextBgRadius(BaseAIOUtils.f(URLDrawableHelper.getRoundCorner(), resources));
        }
        if (z18 && !TextUtils.isEmpty(str6) && view2 != null && (tag = view2.getTag(R.id.f166926j53)) != null && (tag instanceof StructMsgItemVideo.e)) {
            ((StructMsgItemVideo.e) tag).f290523c.setText(str6);
        }
        if (!z18 && (textView = textView2) != null) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            if (view2 != null) {
                layoutParams2.addRule(8, view2.getId());
            }
            E.addView(textView, layoutParams2);
        }
        E.setId(R.id.f166923j50);
        return E;
    }
}

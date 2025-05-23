package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.impl.PublicAccountConfigAttrImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends b {
    public c(Context context, ArrayList<IPublicAccountConfigAttr.a> arrayList, ay.a aVar, String str, String str2) {
        super(context, arrayList, aVar, str, str2);
    }

    public static View e(Context context, View view, ViewGroup viewGroup, PublicAccountConfigAttrImpl publicAccountConfigAttrImpl, int i3, ay.a aVar, String str, String str2) {
        LinearLayout linearLayout;
        ArrayList<IPublicAccountConfigAttr.a> b16 = b.b(publicAccountConfigAttrImpl, i3);
        if (b16.size() % 2 != 0) {
            b16.remove(b16.size() - 1);
            if (QLog.isDevelopLevel()) {
                QLog.d("AccountDetailJigsawViewWrapper", 2, "createView remove last data!");
            }
        }
        if (b16.isEmpty()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AccountDetailJigsawViewWrapper", 2, "createView return convertView!");
            }
            return view;
        }
        if (view != null && (view instanceof LinearLayout)) {
            linearLayout = (LinearLayout) view;
        } else {
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(1);
            linearLayout2.setPadding(0, BaseAIOUtils.f(20.0f, viewGroup.getResources()), 0, 0);
            linearLayout = linearLayout2;
        }
        Object tag = linearLayout.getTag();
        if (tag != null && (tag instanceof c) && ((c) tag).a(b16)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AccountDetailJigsawViewWrapper", 2, "createView reuse!");
            }
            return linearLayout;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("AccountDetailJigsawViewWrapper", 2, "createView new create!");
        }
        c cVar = new c(context, b16, aVar, str, str2);
        cVar.d(linearLayout);
        linearLayout.setTag(cVar);
        return linearLayout;
    }

    private void d(LinearLayout linearLayout) {
        ViewGroup viewGroup;
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailJigsawViewWrapper", 2, "buildView!");
        }
        linearLayout.removeAllViews();
        linearLayout.setClickable(false);
        Drawable drawable = null;
        linearLayout.setOnClickListener(null);
        Context context = linearLayout.getContext();
        Resources resources = context.getResources();
        int f16 = BaseAIOUtils.f(2.0f, resources);
        int i3 = (resources.getDisplayMetrics().widthPixels - f16) / 2;
        int f17 = BaseAIOUtils.f(125.0f, resources);
        int i16 = 0;
        while (i16 < this.f79255a.size()) {
            boolean z16 = i16 % 2 == 0;
            int i17 = i16 / 2;
            boolean z17 = i17 == 0;
            if (z16) {
                LinearLayout linearLayout2 = new LinearLayout(context);
                linearLayout2.setOrientation(0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, f17);
                if (!z17) {
                    layoutParams.setMargins(0, f16, 0, 0);
                }
                linearLayout2.setLayoutParams(layoutParams);
                linearLayout.addView(linearLayout2);
                viewGroup = linearLayout2;
            } else {
                viewGroup = (LinearLayout) linearLayout.getChildAt(i17);
            }
            IPublicAccountConfigAttr.a aVar = this.f79255a.get(i16);
            RelativeLayout relativeLayout = new RelativeLayout(context);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, f17);
            if (!z16) {
                layoutParams2.setMargins(f16, 0, 0, 0);
            }
            relativeLayout.setLayoutParams(layoutParams2);
            relativeLayout.setTag(aVar);
            relativeLayout.setOnClickListener(this.f79260f);
            viewGroup.addView(relativeLayout);
            URLImageView uRLImageView = new URLImageView(context);
            uRLImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            uRLImageView.setBackgroundDrawable(URLDrawable.getDrawable(aVar.f79339k, drawable, drawable, true));
            uRLImageView.setImageDrawable(new ColorDrawable(Color.parseColor(GameCenterVideoViewController.GRAY_MASK)));
            uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            relativeLayout.addView(uRLImageView);
            TextView textView = new TextView(context);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams3.setMargins(BaseAIOUtils.f(20.0f, this.f79256b.getResources()), 0, BaseAIOUtils.f(20.0f, this.f79256b.getResources()), 0);
            textView.setLayoutParams(layoutParams3);
            textView.setGravity(17);
            textView.setText(aVar.f79330b);
            textView.setTextColor(-1);
            textView.setTextSize(2, 16.0f);
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            relativeLayout.addView(textView);
            i16++;
            drawable = null;
        }
    }
}

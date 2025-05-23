package com.tencent.mobileqq.guild.robot.components.base.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RobotLabelLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private List<String> f232139d;

    /* renamed from: e, reason: collision with root package name */
    private int f232140e;

    /* renamed from: f, reason: collision with root package name */
    private int f232141f;

    /* renamed from: h, reason: collision with root package name */
    private int f232142h;

    /* renamed from: i, reason: collision with root package name */
    private int f232143i;

    /* renamed from: m, reason: collision with root package name */
    private int f232144m;

    public RobotLabelLayout(Context context) {
        super(context);
        this.f232139d = new ArrayList();
    }

    private TextView a(boolean z16) {
        TextView textView = new TextView(getContext());
        textView.setPadding(this.f232140e, this.f232142h, this.f232141f, this.f232143i);
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, ViewUtils.dpToPx(17.0f));
        }
        if (!z16) {
            layoutParams.leftMargin = this.f232144m;
        }
        textView.setTextColor(getResources().getColor(R.color.guild_robot_list_label_text_color));
        textView.setBackgroundResource(R.drawable.guild_robot_list_label_bg);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        textView.setTextSize(10.0f);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    public void b(List<String> list) {
        boolean z16;
        if (list != null && list.size() != 0) {
            this.f232139d.clear();
            this.f232139d.addAll(list);
            int size = list.size() - getChildCount();
            for (int i3 = 0; i3 < size; i3++) {
                if (getChildCount() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                addView(a(z16));
            }
            for (int i16 = 0; i16 < list.size(); i16++) {
                String str = list.get(i16);
                if (str.length() > 8) {
                    str = str.substring(0, 8) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                View childAt = getChildAt(i16);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setText(str);
                }
            }
        }
    }

    public void setLabelMargin(int i3) {
        this.f232144m = i3;
    }

    @Override // android.view.View
    public void setPadding(int i3, int i16, int i17, int i18) {
        this.f232140e = i3;
        this.f232141f = i16;
        this.f232142h = i17;
        this.f232143i = i18;
    }

    public RobotLabelLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f232139d = new ArrayList();
    }
}

package com.tencent.biz.qqcircle.fragments.message.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSChatGiftRecordView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f84520d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f84521e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f84522f;

    /* renamed from: h, reason: collision with root package name */
    private String f84523h;

    /* renamed from: i, reason: collision with root package name */
    private GradientDrawable f84524i;

    public QFSChatGiftRecordView(Context context) {
        this(context, null);
    }

    protected void a(Context context, AttributeSet attributeSet) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.g2e, this);
        this.f84520d = viewGroup;
        viewGroup.setLayoutParams(new LinearLayout.LayoutParams(-2, cx.a(16.0f)));
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f84524i = gradientDrawable;
        gradientDrawable.setColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_tag_selected));
        this.f84524i.setCornerRadius(cx.a(8.5f));
        this.f84520d.setBackgroundDrawable(this.f84524i);
        this.f84521e = (ImageView) this.f84520d.findViewById(R.id.y3p);
        this.f84522f = (TextView) this.f84520d.findViewById(R.id.f108236ck);
    }

    public void setGiftCount(int i3) {
        this.f84523h = HippyTKDListViewAdapter.X + i3;
        TextView textView = this.f84522f;
        if (textView != null) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            this.f84522f.setText(this.f84523h);
        }
    }

    public void setIconUrl(String str) {
        if (this.f84521e != null) {
            Option obtain = Option.obtain();
            obtain.setUrl(str).setTargetView(this.f84521e).setLoadingDrawable(getResources().getDrawable(R.drawable.trans));
            QCircleFeedPicLoader.g().loadImage(obtain);
        }
    }

    public void setUIStyle(String str, String str2) {
        try {
            TextView textView = this.f84522f;
            if (textView != null) {
                textView.setTextColor(Color.parseColor(str));
            }
            GradientDrawable gradientDrawable = this.f84524i;
            if (gradientDrawable != null) {
                gradientDrawable.setColor(Color.parseColor(str2));
            }
        } catch (Exception unused) {
            QLog.e("QFSChatGiftRecordView", 1, "setUIStyle numColor:", str, ",backColor:", str2);
        }
    }

    public QFSChatGiftRecordView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSChatGiftRecordView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context, attributeSet);
    }
}

package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

/* loaded from: classes4.dex */
public class QFSPersonalEditNormalTextView extends LinearLayout {
    private boolean C;
    private final CompoundButton.OnCheckedChangeListener D;

    /* renamed from: d, reason: collision with root package name */
    private FormItemRelativeLayout f89247d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f89248e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f89249f;

    /* renamed from: h, reason: collision with root package name */
    private QCircleAvatarView f89250h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f89251i;

    /* renamed from: m, reason: collision with root package name */
    private Switch f89252m;

    /* loaded from: classes4.dex */
    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            QFSPersonalEditNormalTextView.this.C = z16;
            QFSPersonalEditNormalTextView.a(QFSPersonalEditNormalTextView.this);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
    }

    public QFSPersonalEditNormalTextView(Context context) {
        super(context);
        this.D = new a();
    }

    static /* bridge */ /* synthetic */ b a(QFSPersonalEditNormalTextView qFSPersonalEditNormalTextView) {
        qFSPersonalEditNormalTextView.getClass();
        return null;
    }

    private void c(Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.glw, (ViewGroup) null, false);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.f89247d = (FormItemRelativeLayout) inflate.findViewById(R.id.f48231zf);
        this.f89248e = (TextView) inflate.findViewById(R.id.f48251zh);
        this.f89249f = (TextView) inflate.findViewById(R.id.f48221ze);
        this.f89251i = (ImageView) inflate.findViewById(R.id.f48211zd);
        this.f89250h = (QCircleAvatarView) inflate.findViewById(R.id.f48201zc);
        this.f89252m = (Switch) inflate.findViewById(R.id.f48241zg);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.f449862w5);
        String string = obtainStyledAttributes.getString(y91.a.f449901z5);
        String string2 = obtainStyledAttributes.getString(y91.a.f449888y5);
        this.f89247d.setBGType(obtainStyledAttributes.getInt(y91.a.f449875x5, 0));
        obtainStyledAttributes.recycle();
        this.f89248e.setText(string);
        if (string2 != null) {
            this.f89249f.setText(string2);
        } else {
            this.f89249f.setVisibility(8);
        }
        this.f89250h.setVisibility(8);
        d(this.f89252m);
        this.f89252m.setOnCheckedChangeListener(this.D);
        this.f89252m.setVisibility(8);
        addView(inflate, layoutParams);
    }

    private void d(Switch r36) {
        r36.setThumbDrawable(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_switch_btn_dot));
        r36.setTrackDrawable(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_switch_track_bg));
    }

    public void e(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.f89249f.setVisibility(8);
                    this.f89250h.setVisibility(8);
                    this.f89252m.setVisibility(0);
                    return;
                }
                return;
            }
            this.f89249f.setVisibility(0);
            this.f89250h.setVisibility(8);
            this.f89252m.setVisibility(8);
            return;
        }
        this.f89249f.setVisibility(8);
        this.f89250h.setVisibility(0);
        this.f89252m.setVisibility(8);
    }

    public void setAvatar(String str, long j3) {
        this.f89250h.setAvatar(str, String.valueOf(j3), com.tencent.biz.qqcircle.immersive.utils.n.a(getContext(), R.dimen.f159391d02));
        e(1);
    }

    public void setBGType(int i3) {
        this.f89247d.setBGType(i3);
    }

    public void setChecked(boolean z16) {
        this.C = z16;
        this.f89252m.setChecked(z16);
        e(3);
    }

    public void setCheckedOnly(boolean z16) {
        this.f89252m.setOnCheckedChangeListener(null);
        setChecked(z16);
        this.f89252m.setOnCheckedChangeListener(this.D);
    }

    public void setRedPointVisible(boolean z16) {
        int i3;
        ImageView imageView = this.f89251i;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public void setText(String str) {
        this.f89249f.setText(str);
        e(2);
    }

    public QFSPersonalEditNormalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = new a();
        c(context, attributeSet);
    }

    public void setListener(b bVar) {
    }
}

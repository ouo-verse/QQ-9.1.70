package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AlbumChooserView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public TextView f152682a;

    /* renamed from: b, reason: collision with root package name */
    public WeImageView f152683b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f152684c;

    /* renamed from: d, reason: collision with root package name */
    public OnAlbumChooserViewClick f152685d;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface OnAlbumChooserViewClick {
        void onAlbumChooserViewClick();
    }

    public AlbumChooserView(Context context) {
        super(context);
        this.f152684c = false;
        a(context);
    }

    public void initAlbumTxt(String str) {
        this.f152682a.setText(str);
    }

    public void playAlbumIconAnim() {
        if (this.f152684c) {
            return;
        }
        this.f152684c = true;
        this.f152683b.animate().rotationBy(180.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.tencent.mm.ui.widget.AlbumChooserView.2
            @Override // java.lang.Runnable
            public void run() {
                AlbumChooserView.this.f152684c = false;
            }
        }).start();
    }

    public void setOnAlbumChooserViewClick(OnAlbumChooserViewClick onAlbumChooserViewClick) {
        this.f152685d = onAlbumChooserViewClick;
    }

    public void updateAlbumTxt(String str) {
        playAlbumIconAnim(str);
    }

    public void initAlbumTxt(String str, int i3, int i16, int i17, int i18) {
        this.f152682a.setText(str);
        this.f152682a.setTextColor(getContext().getResources().getColor(i3));
        ((LinearLayout) this.f152682a.getParent()).setBackground(getContext().getResources().getDrawable(i18));
        this.f152683b.setIconColor(getContext().getResources().getColor(i16));
        ((FrameLayout) this.f152683b.getParent()).setBackground(getContext().getResources().getDrawable(i17));
    }

    public final void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dwy, (ViewGroup) this, true);
        this.f152682a = (TextView) inflate.findViewById(R.id.skl);
        WeImageView weImageView = (WeImageView) inflate.findViewById(R.id.skk);
        this.f152683b = weImageView;
        weImageView.setRotation(90.0f);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.AlbumChooserView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlbumChooserView.this.f152685d != null) {
                    AlbumChooserView.this.f152685d.onAlbumChooserViewClick();
                }
            }
        });
    }

    public AlbumChooserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f152684c = false;
        a(context);
    }

    public void playAlbumIconAnim(final String str) {
        if (this.f152684c) {
            return;
        }
        this.f152684c = true;
        this.f152683b.animate().rotationBy(180.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.tencent.mm.ui.widget.AlbumChooserView.3
            @Override // java.lang.Runnable
            public void run() {
                AlbumChooserView.this.f152684c = false;
                AlbumChooserView.this.f152682a.setText(str);
            }
        }).start();
    }

    public AlbumChooserView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f152684c = false;
        a(context);
    }
}

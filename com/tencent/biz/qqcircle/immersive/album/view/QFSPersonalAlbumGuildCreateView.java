package com.tencent.biz.qqcircle.immersive.album.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;

/* loaded from: classes4.dex */
public class QFSPersonalAlbumGuildCreateView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private Context f84853d;

    /* renamed from: e, reason: collision with root package name */
    private View f84854e;

    public QFSPersonalAlbumGuildCreateView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    private void b(Context context) {
        this.f84853d = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.gl5, (ViewGroup) this, false);
        this.f84854e = inflate;
        addView(inflate);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        View view = this.f84854e;
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.album.view.QFSPersonalAlbumGuildCreateView.1
                @Override // java.lang.Runnable
                public void run() {
                    QFSPersonalAlbumGuildCreateView.this.f84854e.setVisibility(8);
                }
            }, 3000L);
        }
    }

    public QFSPersonalAlbumGuildCreateView(@NonNull Context context) {
        super(context);
        b(context);
    }
}

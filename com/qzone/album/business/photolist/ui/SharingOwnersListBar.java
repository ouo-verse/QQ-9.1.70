package com.qzone.album.business.photolist.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.module.feedcomponent.view.AvatarImageView;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SharingOwnersListBar extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    Context f43299d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f43300e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<AvatarImageView> f43301f;

    public SharingOwnersListBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f43299d = context;
        this.f43301f = new ArrayList<>();
        c();
    }

    private AvatarImageView a(long j3, int i3, int i16) {
        AvatarImageView avatarImageView;
        if (this.f43301f.size() > 0) {
            avatarImageView = this.f43301f.get(0);
            this.f43301f.remove(avatarImageView);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) avatarImageView.getLayoutParams();
            layoutParams.setMargins(i16, 0, 0, 0);
            avatarImageView.setLayoutParams(layoutParams);
        } else {
            AvatarImageView avatarImageView2 = new AvatarImageView(this.f43299d);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i3, i3);
            layoutParams2.setMargins(i16, 0, 0, 0);
            avatarImageView2.setLayoutParams(layoutParams2);
            avatarImageView2.setForeground((Drawable) null);
            avatarImageView2.setClickable(false);
            avatarImageView2.setBackgroundDrawable(getResources().getDrawable(R.drawable.aqe));
            avatarImageView = avatarImageView2;
        }
        avatarImageView.loadAvatar(j3);
        return avatarImageView;
    }

    private View b(int i3, int i16, int i17) {
        TextView textView = new TextView(this.f43299d);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i16, i16);
        layoutParams.setMargins(i17, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setText("");
        textView.setTextSize(12.0f);
        textView.setIncludeFontPadding(false);
        textView.setTextColor(getResources().getColor(R.color.f158017al3));
        textView.setGravity(17);
        textView.setBackgroundResource(R.drawable.hx6);
        return textView;
    }

    private void c() {
        LayoutInflater.from(this.f43299d).inflate(R.layout.big, this);
        this.f43300e = (FrameLayout) findViewById(R.id.f164276qf);
    }

    private void d() {
        if (this.f43300e.getChildCount() > 0) {
            for (int i3 = 0; i3 < this.f43300e.getChildCount(); i3++) {
                if (this.f43300e.getChildAt(i3) instanceof AvatarImageView) {
                    this.f43301f.add((AvatarImageView) this.f43300e.getChildAt(i3));
                }
            }
        }
        this.f43300e.removeAllViews();
    }

    public void f(AlbumCacheData albumCacheData, ArrayList<Long> arrayList, int i3, int i16, int i17, boolean z16) {
        int size = arrayList.size();
        int i18 = i16 - i17;
        d();
        if (size > i3) {
            int i19 = 0;
            while (i19 < i3) {
                this.f43300e.addView(a(arrayList.get(i19).longValue(), i16, (i18 - ar.d(2.0f)) * i19), 0);
                i19++;
            }
            if (z16) {
                this.f43300e.addView(b(size, i16, i19 * (i18 - ar.d(2.0f))), 0);
                return;
            }
            return;
        }
        int i26 = 0;
        while (i26 < size) {
            this.f43300e.addView(a(arrayList.get(i26).longValue(), i16, (i18 - ar.d(2.0f)) * i26), 0);
            i26++;
        }
        if (z16) {
            this.f43300e.addView(b(size, i16, i26 * (i18 - ar.d(2.0f))), 0);
        }
    }

    public void e(AlbumCacheData albumCacheData, ArrayList<Long> arrayList, int i3, int i16, int i17, boolean z16) {
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int i18 = i16 - i17;
        d();
        int i19 = 0;
        if (size <= i3) {
            while (i19 < size) {
                this.f43300e.addView(a(arrayList.get(i19).longValue(), i16, i19 * i18));
                i19++;
            }
            return;
        }
        while (i19 < i3 - 1) {
            this.f43300e.addView(a(arrayList.get(i19).longValue(), i16, i19 * i18));
            i19++;
        }
        FrameLayout frameLayout = this.f43300e;
        long longValue = arrayList.get(i19).longValue();
        int i26 = i19 * i18;
        frameLayout.addView(a(longValue, i16, i26));
        this.f43300e.addView(b(size, i16, i26));
    }
}

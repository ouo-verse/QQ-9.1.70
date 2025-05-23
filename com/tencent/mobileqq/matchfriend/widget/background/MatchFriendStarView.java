package com.tencent.mobileqq.matchfriend.widget.background;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendStarView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private final Context f245686d;

    /* renamed from: e, reason: collision with root package name */
    private final List<ImageView> f245687e;

    public MatchFriendStarView(Context context) {
        this(context, null);
    }

    private URLDrawable b(String str, int i3, int i16) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = i3 / 2;
        obtain.mRequestHeight = i16 / 2;
        obtain.mFailedDrawable = new ColorDrawable(0);
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mUseApngImage = true;
        obtain.mExtraInfo = new Bundle();
        obtain.mPlayGifImage = true;
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        if (drawable.getCurrDrawable() instanceof ApngDrawable) {
            d(drawable);
        } else {
            drawable.setURLDrawableListener(new a());
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(URLDrawable uRLDrawable) {
        Drawable currDrawable = uRLDrawable.getCurrDrawable();
        if (currDrawable instanceof ApngDrawable) {
            ApngDrawable apngDrawable = (ApngDrawable) currDrawable;
            apngDrawable.getImage().setSupportGlobalPasued(false);
            apngDrawable.resume();
        }
    }

    private void e() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f245686d).inflate(R.layout.cwc, (ViewGroup) this, true);
        this.f245687e.add((ImageView) viewGroup.findViewById(R.id.ok9));
        this.f245687e.add((ImageView) viewGroup.findViewById(R.id.ok_));
        this.f245687e.add((ImageView) viewGroup.findViewById(R.id.oka));
        this.f245687e.add((ImageView) viewGroup.findViewById(R.id.okb));
        int screenWidth = ViewUtils.getScreenWidth();
        int screenHeight = ViewUtils.getScreenHeight();
        for (int i3 = 0; i3 < this.f245687e.size(); i3++) {
            this.f245687e.get(i3).setImageDrawable(b(c(i3), screenWidth, screenHeight));
        }
    }

    public MatchFriendStarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private String c(int i3) {
        return String.format("https://downv6.qq.com/extendfriend/star_new_%d.png", Integer.valueOf(i3));
    }

    public MatchFriendStarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f245687e = new ArrayList();
        this.f245686d = context;
        e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements URLDrawable.URLDrawableListener {
        a() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            MatchFriendStarView.d(uRLDrawable);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}

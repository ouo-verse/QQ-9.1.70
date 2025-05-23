package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.widget.RoundRectImageView;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedTopThumbView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private RoundRectImageView f224228d;

    /* renamed from: e, reason: collision with root package name */
    private View f224229e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f224230f;

    /* renamed from: h, reason: collision with root package name */
    private String f224231h;

    /* renamed from: i, reason: collision with root package name */
    private int f224232i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a extends GuildPicStateListener {
        a(boolean z16) {
            super(z16);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState loadState, Option option) {
            if (loadState == LoadState.STATE_SUCCESS) {
                GuildFeedTopThumbView.this.f224229e.setVisibility(0);
                if (GuildFeedTopThumbView.this.f224232i == 2) {
                    GuildFeedTopThumbView.this.f224230f.setVisibility(0);
                }
            }
        }
    }

    public GuildFeedTopThumbView(Context context) {
        this(context, null);
    }

    private void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.erq, (ViewGroup) this, true);
        this.f224228d = (RoundRectImageView) findViewById(R.id.f70653m1);
        this.f224229e = findViewById(R.id.uzj);
        this.f224230f = (ImageView) findViewById(R.id.kro);
        this.f224228d.setCornerRadiusAndMode(com.tencent.mobileqq.guild.feed.util.e.a(getContext(), 2.0f), 1);
    }

    private void e() {
        if (TextUtils.isEmpty(this.f224231h)) {
            return;
        }
        com.tencent.mobileqq.guild.picload.e.a().f(Option.obtain().setTargetView(this.f224228d).setUrl(this.f224231h).setNeedShowLoadingDrawable(false).setRequestWidth(com.tencent.mobileqq.guild.feed.util.e.a(getContext(), 25.0f)).setRegionHeight(com.tencent.mobileqq.guild.feed.util.e.a(getContext(), 25.0f)), new a(true));
    }

    public void setThumbData(String str, int i3) {
        this.f224231h = str;
        this.f224232i = i3;
        e();
    }

    public GuildFeedTopThumbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildFeedTopThumbView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f224231h = "";
        this.f224232i = -1;
        d();
    }
}

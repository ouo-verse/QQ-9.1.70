package com.tencent.timi.game.team.impl.team;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarSpeakingMicImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;

/* compiled from: P */
/* loaded from: classes26.dex */
public class h extends RecyclerView.ViewHolder {
    public AvatarRoundImageView E;
    public AvatarTextView F;
    public ImageView G;
    public TextView H;
    public AvatarSpeakingMicImageView I;
    public MicWaveViewLottie J;
    public ImageView K;
    public URLImageView L;
    public TextView M;
    public URLImageView N;
    public ImageView P;
    public TeamLaneStateView Q;
    public TextView R;
    public ImageView S;

    public h(@NonNull View view, long j3) {
        super(view);
        this.E = (AvatarRoundImageView) view.findViewById(R.id.f165334vl2);
        this.F = (AvatarTextView) view.findViewById(R.id.f93455_m);
        this.G = (ImageView) view.findViewById(R.id.vl5);
        this.H = (TextView) view.findViewById(R.id.vl6);
        this.I = (AvatarSpeakingMicImageView) view.findViewById(R.id.f165336vl4);
        this.J = (MicWaveViewLottie) view.findViewById(R.id.vl7);
        this.K = (ImageView) view.findViewById(R.id.f165333vl1);
        this.L = (URLImageView) view.findViewById(R.id.vkz);
        this.M = (TextView) view.findViewById(R.id.f165332vl0);
        this.N = (URLImageView) view.findViewById(R.id.vpf);
        this.P = (ImageView) view.findViewById(R.id.vq5);
        this.Q = (TeamLaneStateView) view.findViewById(R.id.f93395_g);
        this.S = (ImageView) view.findViewById(R.id.f93445_l);
        this.R = (TextView) view.findViewById(R.id.f93405_h);
    }
}

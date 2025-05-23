package com.tencent.biz.qqcircle.immersive.personal.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalCollectFragment;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalPraisedFeedFragment;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalPushedFeedFragment;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i extends FragmentStateAdapter {
    private int C;
    private int D;
    private int E;
    private int F;

    /* renamed from: m, reason: collision with root package name */
    private int f88385m;

    public i(@NonNull Fragment fragment) {
        super(fragment);
        this.f88385m = -1;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        this.F = -1;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NonNull
    public Fragment createFragment(int i3) {
        if (i3 == this.E) {
            return new QFSPersonalPushedFeedFragment();
        }
        if (i3 == this.D) {
            return new QFSPersonalPraisedFeedFragment();
        }
        if (i3 == this.F) {
            return new QFSPersonalCollectFragment();
        }
        if (i3 == this.C) {
            return QFSPersonalFeedFragment.Hh(ErrorCode.ERROR_FAILED_GET_POST);
        }
        return QFSPersonalFeedFragment.Hh(ErrorCode.ERROR_CMD_INVALID);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        int i3;
        if (this.f88385m != -1) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (this.C != -1) {
            i3++;
        }
        if (this.E != -1) {
            i3++;
        }
        if (this.D != -1) {
            i3++;
        }
        if (this.F != -1) {
            return i3 + 1;
        }
        return i3;
    }

    public void i0(int i3, int i16, int i17, int i18, int i19) {
        this.f88385m = i3;
        notifyDataSetChanged();
    }
}

package com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.empty;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildRightEmptyFragment extends QPublicBaseFragment {
    private ViewGroup C;
    private boolean D = true;

    public static GuildRightEmptyFragment qh(Intent intent) {
        GuildRightEmptyFragment guildRightEmptyFragment = new GuildRightEmptyFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", intent);
        guildRightEmptyFragment.setArguments(bundle);
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Rt.GuildEmptyFragment", 2, "newInstance");
        }
        return guildRightEmptyFragment;
    }

    private void rh(@NonNull ImageView imageView, String str) {
        int d16 = (int) ((bi.d() * 967.0f) / 1284.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.height = (int) ((d16 * 851.0f) / 967.0f);
        layoutParams.width = d16;
        imageView.setLayoutParams(layoutParams);
        imageView.setImageDrawable(URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain()));
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.exl, viewGroup, false);
        this.C = viewGroup2;
        rh((ImageView) viewGroup2.findViewById(R.id.xiw), "https://downv6.qq.com/innovate/guild/empty_view/guild_no_join_view.png");
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Rt.GuildEmptyFragment", 2, "onCreateView");
        }
        if (!this.D) {
            this.C.setVisibility(8);
        }
        ViewGroup viewGroup3 = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup3);
        return viewGroup3;
    }

    public void ph() {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Rt.GuildEmptyFragment", 2, "hide");
        }
        ViewGroup viewGroup = this.C;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            if (QLog.isColorLevel()) {
                QLog.d("Guild.MF.Rt.GuildEmptyFragment", 2, ParseCommon.GONE);
            }
        }
        this.D = false;
    }

    public void show() {
        if (this.C != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild.MF.Rt.GuildEmptyFragment", 2, "show");
            }
            this.C.setVisibility(0);
            this.D = true;
            return;
        }
        throw new NullPointerException("mRootView should never be null!");
    }
}

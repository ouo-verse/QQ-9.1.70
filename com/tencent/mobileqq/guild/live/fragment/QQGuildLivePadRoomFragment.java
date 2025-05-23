package com.tencent.mobileqq.guild.live.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes14.dex */
public class QQGuildLivePadRoomFragment extends QQGuildBaseLiveRoomFragment implements com.tencent.mobileqq.pad.f {
    private void Fh(boolean z16) {
        if (z16) {
            com.tencent.mobileqq.pad.e.b(requireActivity());
        } else {
            com.tencent.mobileqq.pad.e.c(requireActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Gh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment
    void doFinish() {
        if (getActivity() == null) {
            QLog.e("QGL.QQGuildLivePadRoomFragment", 1, "doFinish, get activity is null.");
        } else if (((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isSplashActivity(getActivity())) {
            getActivity().onKeyDown(4, new KeyEvent(4, 4));
        } else {
            finishActivity();
        }
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment
    void doLandscapeToPortraitOrientation() {
        if (GLiveChannelStartParams.fromLittleWorld()) {
            finishActivity();
        } else {
            this.mLiveRoomUiData.b0(0);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        boolean z16;
        super.onConfigurationChanged(configuration);
        if (GLiveChannelStartParams.fromLittleWorld()) {
            finishActivity();
            return;
        }
        if (configuration.orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mLiveRoomUiData.g0(gq1.b.b(getActivity()));
        int m3 = this.mLiveRoomUiData.m();
        if (m3 == 2) {
            checkToUpdateVideoState(true);
        } else if (z16 && m3 == 0) {
            checkToUpdateVideoState(false);
        } else {
            checkToUpdateVideoState(z16);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        clean();
        super.onDestroy();
        QLog.i("QGL.QQGuildLivePadRoomFragment", 1, "onDestroy.");
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment
    protected void onVideoScreenStateChange(int i3) {
        boolean z16;
        closeCardFragment();
        if (AppSetting.t(requireActivity())) {
            if (i3 == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            Fh(z16);
        }
        super.onVideoScreenStateChange(i3);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.QQGuildBaseLiveRoomFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).setGuildChatFragmentShow();
        super.onViewCreated(view, bundle);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.fragment.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QQGuildLivePadRoomFragment.Gh(view2);
            }
        });
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        return false;
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
        Intent intent = requireActivity().getIntent();
        intent.putExtras(getArguments());
        onNewIntent(intent);
    }
}

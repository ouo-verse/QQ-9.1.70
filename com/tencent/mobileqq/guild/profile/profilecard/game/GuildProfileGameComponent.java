package com.tencent.mobileqq.guild.profile.profilecard.game;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.arch.core.util.Function;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profile.profilearchives.fragment.GuildProfileArchivesListFragment;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.de;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import vp1.cq;

/* loaded from: classes14.dex */
public class GuildProfileGameComponent extends AbsGuildProfileComponent implements View.OnClickListener {
    private static final String TAG = "Guild.profile.GuildProfileGameComponent";
    private View divider1;
    private View divider2;
    private boolean isLoading;
    private ViewGroup mArchiveArkViewContentGroup;
    private ViewGroup mArkRootView;
    private Object mArkViewContainer;
    private final int mFullAlpha;
    private g mGameViewModel;
    private final int mHalfAlpha;
    private ImageView mIvGameingAvatar;
    private View mLlProfileArchive;
    private RelativeLayout mRlGameing;
    private TextView mTvGameingDesc;
    private TextView mTvGameingLabel;
    private TextView mTvGameingName;
    private TextView mTvMoreGame;
    private TextView mTvProfileArchive;
    private int visibility;

    public GuildProfileGameComponent(IGuildComponentController iGuildComponentController, GuildProfileData guildProfileData) {
        super(iGuildComponentController, guildProfileData);
        this.mFullAlpha = 255;
        this.mHalfAlpha = 127;
        this.visibility = 8;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void bindUI() {
        this.mTvGameingLabel = (TextView) this.mViewContainer.findViewById(R.id.x39);
        this.mRlGameing = (RelativeLayout) this.mViewContainer.findViewById(R.id.f165602ww2);
        this.mIvGameingAvatar = (ImageView) this.mViewContainer.findViewById(R.id.wkc);
        this.mTvGameingName = (TextView) this.mViewContainer.findViewById(R.id.x3_);
        this.mTvGameingDesc = (TextView) this.mViewContainer.findViewById(R.id.x38);
        this.mTvMoreGame = (TextView) this.mViewContainer.findViewById(R.id.x36);
        this.mTvProfileArchive = (TextView) this.mViewContainer.findViewById(R.id.f165643x35);
        this.mLlProfileArchive = this.mViewContainer.findViewById(R.id.wom);
        this.mArkRootView = (ViewGroup) this.mViewContainer.findViewById(R.id.wfv);
        this.mTvMoreGame.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.profile.profilecard.game.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean lambda$bindUI$0;
                lambda$bindUI$0 = GuildProfileGameComponent.this.lambda$bindUI$0(view, motionEvent);
                return lambda$bindUI$0;
            }
        });
        this.divider1 = this.mViewContainer.findViewById(R.id.f165000bn4);
        this.divider2 = this.mViewContainer.findViewById(R.id.bn5);
        Drawable drawable = this.mTvMoreGame.getCompoundDrawables()[2];
        drawable.setBounds(0, 0, ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(16.0f));
        this.mTvMoreGame.setCompoundDrawables(null, null, drawable, null);
    }

    private boolean canShowGameComponent(GuildBaseProfileData guildBaseProfileData) {
        if (guildBaseProfileData == null) {
            return false;
        }
        if (guildBaseProfileData.e().equals("0") && isSelf(guildBaseProfileData)) {
            return false;
        }
        return true;
    }

    private void dtViewReport(View view, String str, boolean z16) {
        String str2;
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        if (z16) {
            str2 = "clck";
        } else {
            str2 = "imp";
        }
        VideoReport.reportEvent(str2, view, new HashMap());
    }

    private <T> LiveData<T> getDelayLiveData(LiveData<T> liveData, final long j3) {
        return Transformations.switchMap(liveData, new Function() { // from class: com.tencent.mobileqq.guild.profile.profilecard.game.f
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                LiveData lambda$getDelayLiveData$4;
                lambda$getDelayLiveData$4 = GuildProfileGameComponent.lambda$getDelayLiveData$4(j3, obj);
                return lambda$getDelayLiveData$4;
            }
        });
    }

    private void initArchiveArkView(a aVar) {
        de a16 = aVar.a().a();
        t02.a aVar2 = new t02.a(a16.getApp(), a16.getView(), a16.getDesc(), a16.b(), a16.a(), a16.getConfig());
        IGuildFeatureAdapterApi iGuildFeatureAdapterApi = (IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class);
        Object obj = this.mArkViewContainer;
        this.mArkViewContainer = iGuildFeatureAdapterApi.initArkViewContainer();
        if (this.mArchiveArkViewContentGroup == null) {
            aVar2.h(ScreenUtil.dip2px(32.0f));
            ViewGroup buildArkViewContentGroup = iGuildFeatureAdapterApi.buildArkViewContentGroup(this.mFragment.getContext(), this.mArkViewContainer, aVar2, this.mArchiveArkViewContentGroup);
            this.mArchiveArkViewContentGroup = buildArkViewContentGroup;
            buildArkViewContentGroup.setId(R.id.f165542wk2);
            this.mArkRootView.addView(this.mArchiveArkViewContentGroup);
        } else {
            iGuildFeatureAdapterApi.buildArkViewContentGroup(this.mFragment.getContext(), this.mArkViewContainer, aVar2, this.mArchiveArkViewContentGroup);
        }
        if (obj != null) {
            iGuildFeatureAdapterApi.destroyArkViewContainer(obj);
        }
        if (aVar.b()) {
            this.mTvMoreGame.setVisibility(0);
            this.mTvMoreGame.setOnClickListener(this);
            VideoReport.reportEvent("imp", this.mTvMoreGame, new HashMap());
        } else {
            this.mTvMoreGame.setVisibility(8);
        }
        dtViewReport(this.mArchiveArkViewContentGroup, "em_sgrp_record", false);
    }

    private void initViewModel(GuildProfileData guildProfileData) {
        g gVar = (g) g.E.create(g.class);
        this.mGameViewModel = gVar;
        gVar.Q1(guildProfileData);
        this.mGameViewModel.S1().observe(this.mFragment, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.game.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileGameComponent.this.lambda$initViewModel$1((h) obj);
            }
        });
        getDelayLiveData(this.mGameViewModel.R1(), 100L).observe(this.mFragment, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.game.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileGameComponent.this.lambda$initViewModel$2((a) obj);
            }
        });
    }

    private boolean isSelf(GuildBaseProfileData guildBaseProfileData) {
        String j3 = guildBaseProfileData.j();
        String b16 = guildBaseProfileData.b();
        IGPSService iGPSService = (IGPSService) ch.S0(IGPSService.class, "");
        if (!TextUtils.equals(j3, b16) && !TextUtils.equals(b16, iGPSService.getSelfTinyId())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$bindUI$0(View view, MotionEvent motionEvent) {
        return setTextViewDrawableSelector(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LiveData lambda$getDelayLiveData$4(long j3, final Object obj) {
        final MutableLiveData mutableLiveData = new MutableLiveData();
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.guild.profile.profilecard.game.e
            @Override // java.lang.Runnable
            public final void run() {
                MutableLiveData.this.postValue(obj);
            }
        }, 16, null, false, j3);
        return mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViewModel$1(h hVar) {
        if (hVar == null) {
            if (this.mGameViewModel.R1().getValue() == null) {
                setContainerVisibleAwareLoading(8);
            }
            this.divider1.setVisibility(8);
            this.mTvGameingLabel.setVisibility(8);
            this.mRlGameing.setVisibility(8);
            return;
        }
        setContainerVisibleAwareLoading(0);
        showGameingUI(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViewModel$2(a aVar) {
        if (aVar == null) {
            if (this.mGameViewModel.S1().getValue() == null) {
                setContainerVisibleAwareLoading(8);
            }
            this.divider2.setVisibility(8);
            this.mLlProfileArchive.setVisibility(8);
            this.mTvProfileArchive.setVisibility(8);
            this.mTvMoreGame.setVisibility(8);
            this.mArkRootView.setVisibility(8);
            return;
        }
        setContainerVisibleAwareLoading(0);
        this.mTvProfileArchive.setVisibility(0);
        this.divider2.setVisibility(0);
        this.mLlProfileArchive.setVisibility(0);
        this.mArkRootView.setVisibility(0);
        initArchiveArkView(aVar);
    }

    private void openProfileArchivePage() {
        Bundle bundle = new Bundle();
        GuildBaseProfileData guildBaseProfileData = this.mData.getGuildBaseProfileData();
        bundle.putBoolean("is_owner", guildBaseProfileData.j().equals(guildBaseProfileData.b()));
        GuildProfileArchivesListFragment.Jh(this.mFragment.getActivity(), bundle, guildBaseProfileData.b(), guildBaseProfileData.e());
    }

    private void setContainerVisibleAwareLoading(int i3) {
        int i16;
        if (canShowGameComponent(this.mGameViewModel.getGuildBaseProfileData())) {
            i16 = i3;
        } else {
            i16 = 8;
        }
        this.visibility = i16;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "setContainerVisibleAwareLoading , before visibility " + i3 + ", after visibility " + this.visibility);
        }
        if (!this.isLoading) {
            this.mViewContainer.setVisibility(i3);
        }
    }

    private void setDTReport() {
        ch.Y0(this.mTvMoreGame, "em_sgrp_otherapp_more", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    }

    private boolean setTextViewDrawableSelector(MotionEvent motionEvent) {
        Drawable drawable;
        int action = motionEvent.getAction();
        Drawable[] compoundDrawables = this.mTvMoreGame.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length >= 3 && (drawable = compoundDrawables[2]) != null) {
            if (action == 0) {
                drawable.setAlpha(127);
            } else if (action == 1 || action == 3) {
                drawable.setAlpha(255);
            }
            this.mTvMoreGame.setCompoundDrawables(null, null, drawable, null);
        }
        return false;
    }

    private void showGameingUI(h hVar) {
        this.divider1.setVisibility(0);
        this.mTvGameingLabel.setVisibility(0);
        this.mRlGameing.setVisibility(0);
        String a16 = hVar.a();
        if (!TextUtils.isEmpty(a16)) {
            int dpToPx = ViewUtils.dpToPx(50.0f);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = dpToPx;
            obtain.mRequestHeight = dpToPx;
            URLDrawable drawable = URLDrawable.getDrawable(a16, obtain);
            this.mIvGameingAvatar.setVisibility(0);
            this.mIvGameingAvatar.setImageDrawable(drawable);
        }
        String b16 = hVar.b();
        if (!TextUtils.isEmpty(b16)) {
            this.mTvGameingName.setVisibility(0);
            this.mTvGameingName.setText(b16);
        }
        String c16 = hVar.c();
        if (!TextUtils.isEmpty(c16)) {
            this.mTvGameingDesc.setVisibility(0);
            this.mTvGameingDesc.setText(c16);
        }
        dtViewReport(this.mRlGameing, "em_sgrp_playing", false);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    protected View createView(Context context) {
        return cq.g(LayoutInflater.from(context)).getRoot();
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public int getComponentType() {
        return 1003;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public int getContentLayoutId() {
        return R.layout.f168144f20;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.x36) {
            openProfileArchivePage();
            getComponentController().handleDismissAction();
            VideoReport.reportEvent("clck", this.mTvMoreGame, new HashMap());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onCreate(Fragment fragment, AppInterface appInterface, Bundle bundle) {
        super.onCreate(fragment, appInterface, bundle);
        bindUI();
        setDTReport();
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onDestroy() {
        super.onDestroy();
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).destroyArkViewContainer(this.mArkViewContainer);
        this.mArkViewContainer = null;
        this.mArchiveArkViewContentGroup = null;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onLoadFinish() {
        this.isLoading = false;
        setContainerVisibleAwareLoading(this.visibility);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onLoadStart() {
        this.isLoading = true;
        this.mViewContainer.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onInitData(GuildProfileData guildProfileData) {
        super.onInitData(guildProfileData);
        initViewModel(guildProfileData);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onUpdateData(GuildProfileData guildProfileData) {
        super.onUpdateData(guildProfileData);
        g gVar = this.mGameViewModel;
        if (gVar != null) {
            gVar.Q1(guildProfileData);
        }
    }
}

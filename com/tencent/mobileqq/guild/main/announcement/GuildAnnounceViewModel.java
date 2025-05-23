package com.tencent.mobileqq.guild.main.announcement;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeJoinInfo;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBannerBizId;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import xq1.Announcement;
import xq1.c;
import xq1.d;
import xq1.e;
import xq1.f;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildAnnounceViewModel extends com.tencent.mobileqq.guild.base.b<wy1.a> {
    private static final String TAG = "Guild.ann.GuildAnnounceViewModel";
    private a mAnnouncementUpdateListener;
    private IGProChannelInfo mChannelInfo;
    private b mChannelUpdateListener;
    private IGProGlobalBanner mGuildBanner;
    private MutableLiveData<String> mGuildIdLive;
    private IGProGuildInfo mGuildInfo;
    private MutableLiveData<Boolean> mHideAnnouncementView;
    private FacadeJoinInfo mJoinInfo;
    private GuildAppReportSourceInfo mReportSourceInfo;
    private MutableLiveData<d> mUpdateGuildBanner;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    private class a implements e {
        a() {
        }

        @Override // xq1.e
        public void a(Announcement announcement) {
            GuildAnnounceViewModel.this.updateGuildBanner(announcement.getGlobalBanner());
        }

        @Override // xq1.e
        public void b(Announcement announcement) {
            GuildAnnounceViewModel.this.removeGuildBanner(announcement.getGlobalBanner());
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    private class b implements f {
        b() {
        }

        private void d(String str, String str2) {
            if (TextUtils.equals(str2, String.valueOf(GuildAnnounceViewModel.this.mGuildBanner.getBizId().getChannelId()))) {
                ((IGPSService) ch.R0(IGPSService.class)).refreshPollingData(str, 7);
            }
        }

        @Override // xq1.f
        public void a(List<String> list) {
            if (ch.r0(list) || GuildAnnounceViewModel.this.checkGuildBannerInvalid()) {
                return;
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                d(GuildAnnounceViewModel.this.mGuildBanner.getGuildId(), it.next());
            }
        }

        @Override // xq1.f
        public void b(String str, String str2, int i3, int i16) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || GuildAnnounceViewModel.this.checkGuildBannerInvalid() || !GuildAnnounceViewModel.this.mGuildBanner.getGuildId().equals(str)) {
                return;
            }
            d(str, str2);
        }

        @Override // xq1.f
        public void c(String str) {
            if (TextUtils.isEmpty(str) || GuildAnnounceViewModel.this.checkGuildBannerInvalid()) {
                return;
            }
            d(GuildAnnounceViewModel.this.mGuildBanner.getGuildId(), str);
        }
    }

    public GuildAnnounceViewModel(wy1.a aVar) {
        super(aVar);
        this.mHideAnnouncementView = new MutableLiveData<>();
        this.mUpdateGuildBanner = new MutableLiveData<>();
        this.mGuildIdLive = new MutableLiveData<>();
        this.mAnnouncementUpdateListener = new a();
        this.mChannelUpdateListener = new b();
        c.g(this.mAnnouncementUpdateListener);
        c.f(this.mChannelUpdateListener);
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean checkBannerShouldHide(@NonNull IGProGlobalBanner iGProGlobalBanner, @NonNull IGProGuildInfo iGProGuildInfo, @Nullable IGProChannelInfo iGProChannelInfo) {
        IGProGuildBannerBizId bizId = iGProGlobalBanner.getBizId();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("checkBannerShouldHide: guildId:%s, channelid:%s, msgId:%d, isHide:%b ", iGProGlobalBanner.getGuildId(), Long.valueOf(bizId.getChannelId()), Long.valueOf(bizId.getMsgSeq()), Boolean.FALSE));
        }
        if (TextUtils.isEmpty(iGProGlobalBanner.getGuildId())) {
            return true;
        }
        if (bw.p0(iGProGlobalBanner.getGuildId(), iGProGlobalBanner.getBannerId())) {
            QLog.d(TAG, 1, "checkBannerShouldHide announcement local closed : " + iGProGlobalBanner.getGuildId());
            return true;
        }
        if (!iGProGuildInfo.isMember()) {
            if (iGProChannelInfo == null) {
                QLog.e(TAG, 1, "checkBannerShouldHide for visitor mChannelInfo is null");
                return true;
            }
            return !iGProGuildInfo.isVisibleForVisitor();
        }
        int bannerType = bizId.getBannerType();
        if (bannerType == 1) {
            if (bizId.getMsgSeq() <= 0) {
                QLog.e(TAG, 1, "checkBannerShouldHide msgSeq is invalid: msgId=" + bizId.getMsgSeq());
                return true;
            }
        } else if (bannerType == 2 && (iGProGlobalBanner.getContent() == null || iGProGlobalBanner.getContent().length <= 0)) {
            QLog.d(TAG, 1, "checkBannerShouldHide GUILD_GLOBAL_BANNER_FEED getContent is empty");
            return true;
        }
        if (bannerType != 6 && bannerType != 7) {
            IGProChannelInfo channelInfo = ((IGPSService) ch.l().getRuntimeService(IGPSService.class, "")).getChannelInfo(String.valueOf(bizId.getChannelId()));
            if (channelInfo == null) {
                QLog.e(TAG, 1, "checkBannerShouldHide mChannelInfo is null");
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("checkBannerShouldHide: getVisibleType:%d", Integer.valueOf(channelInfo.getVisibleType())));
            }
            if (1 != channelInfo.getVisibleType()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkGuildBannerInvalid() {
        if (this.mGuildBanner == null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeGuildBanner(IGProGlobalBanner iGProGlobalBanner) {
        if (iGProGlobalBanner == null) {
            QLog.w(TAG, 1, "onGuildBannerRemoved guildBanner is null!");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onGuildBannerRemoved banner : " + iGProGlobalBanner);
        }
        if (this.mGuildInfo != null && this.mGuildBanner != null) {
            if (!iGProGlobalBanner.getGuildId().equals(this.mGuildInfo.getGuildID())) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onGuildBannerRemoved different curGuildId : " + this.mGuildInfo.getGuildID() + ", updatedGuild: " + iGProGlobalBanner.getGuildId());
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onGuildBannerRemoved now hide banner, updatedGuild: " + iGProGlobalBanner.getGuildId());
            }
            this.mGuildBanner = null;
            updateValue(this.mHideAnnouncementView, Boolean.TRUE);
            return;
        }
        QLog.e(TAG, 1, "onGuildBannerRemoved mGuildInfo is null");
    }

    private void showCurrentGlobalBanner() {
        if (this.mGuildInfo == null) {
            s.f(TAG, "showCurrentGlobalBanner mGuildInfo is null!", new IllegalStateException());
            return;
        }
        IGProGlobalBanner iGProGlobalBanner = this.mGuildBanner;
        if (iGProGlobalBanner == null) {
            s.f(TAG, "showCurrentGlobalBanner mGuildBanner is null!", new IllegalStateException());
            return;
        }
        String valueOf = String.valueOf(iGProGlobalBanner.getBizId().getChannelId());
        String guildId = this.mGuildBanner.getGuildId();
        if (this.mChannelInfo == null) {
            this.mChannelInfo = ((IGPSService) ch.R0(IGPSService.class)).getChannelInfo(valueOf);
        }
        if (this.mChannelInfo == null) {
            QLog.e(TAG, 1, "mChannelInfo is still null, guildId: " + guildId + " channelId: " + valueOf, new IllegalStateException());
            return;
        }
        QLog.i(TAG, 1, "showCurrentGlobalBanner guildId: " + guildId + " channelId: " + valueOf);
        this.mHideAnnouncementView.setValue(Boolean.FALSE);
        this.mUpdateGuildBanner.setValue(new d(this.mGuildInfo, this.mChannelInfo, this.mGuildBanner, this.mJoinInfo, this.mReportSourceInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGuildBanner(IGProGlobalBanner iGProGlobalBanner) {
        String str;
        if (iGProGlobalBanner == null) {
            QLog.w(TAG, 1, "onGuildBannerUpdated guildBanner is null!");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onGuildBannerUpdated banner : " + iGProGlobalBanner + ", bannerId " + iGProGlobalBanner.getBannerId());
        }
        if (this.mGuildInfo == null) {
            QLog.e(TAG, 1, "mGuildInfo is null");
            return;
        }
        if (!iGProGlobalBanner.getGuildId().equals(this.mGuildInfo.getGuildID())) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onGuildBannerUpdated different curGuildId : " + this.mGuildInfo.getGuildID() + ", updatedGuild: " + iGProGlobalBanner.getGuildId());
                return;
            }
            return;
        }
        IGProGlobalBanner iGProGlobalBanner2 = this.mGuildBanner;
        if (iGProGlobalBanner2 != null) {
            str = iGProGlobalBanner2.getBannerId();
        } else {
            str = "";
        }
        this.mGuildBanner = iGProGlobalBanner;
        IGProChannelInfo B = ch.B(String.valueOf(iGProGlobalBanner.getBizId().getChannelId()));
        this.mChannelInfo = B;
        if (checkBannerShouldHide(this.mGuildBanner, this.mGuildInfo, B)) {
            updateValue(this.mHideAnnouncementView, Boolean.TRUE);
        } else if (!TextUtils.equals(str, iGProGlobalBanner.getBannerId())) {
            showCurrentGlobalBanner();
        }
    }

    public void getAnnouncement(IGProGuildInfo iGProGuildInfo) {
        getAnnouncement(iGProGuildInfo, null, null);
    }

    public IGProChannelInfo getChannelInfo() {
        return this.mChannelInfo;
    }

    public IGProGuildInfo getGuildInfo() {
        return this.mGuildInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        c.t(this.mAnnouncementUpdateListener);
        c.s(this.mChannelUpdateListener);
    }

    public void getAnnouncement(IGProGuildInfo iGProGuildInfo, FacadeJoinInfo facadeJoinInfo, GuildAppReportSourceInfo guildAppReportSourceInfo) {
        this.mJoinInfo = facadeJoinInfo;
        this.mReportSourceInfo = guildAppReportSourceInfo;
        if (iGProGuildInfo != null && !TextUtils.isEmpty(iGProGuildInfo.getGuildID())) {
            this.mGuildInfo = iGProGuildInfo;
            this.mGuildIdLive.setValue(iGProGuildInfo.getGuildID());
            Announcement k3 = c.k(this.mGuildInfo.getGuildID(), !this.mGuildInfo.isMember());
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getAnnouncement banner : " + k3);
            }
            IGProGlobalBanner globalBanner = k3.getGlobalBanner();
            if (globalBanner == null) {
                QLog.e(TAG, 1, "guildBanner is null");
                this.mHideAnnouncementView.setValue(Boolean.TRUE);
                return;
            }
            IGProChannelInfo B = ch.B(String.valueOf(globalBanner.getBizId().getChannelId()));
            this.mChannelInfo = B;
            if (checkBannerShouldHide(globalBanner, this.mGuildInfo, B)) {
                this.mHideAnnouncementView.setValue(Boolean.TRUE);
                return;
            } else {
                this.mGuildBanner = globalBanner;
                showCurrentGlobalBanner();
                return;
            }
        }
        QLog.e(TAG, 1, "guildInfo is null or guildId is empty");
        this.mHideAnnouncementView.setValue(Boolean.TRUE);
    }
}

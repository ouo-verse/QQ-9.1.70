package com.qzone.component.banner;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.ViewStub;
import com.qzone.component.banner.Banner;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.personalize.model.CustomPlayerData;
import com.qzone.personalize.music.ui.FriendMusicPlayerBar;
import com.tencent.mobileqq.music.SongInfo;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import e8.f;

/* loaded from: classes39.dex */
public class MusicPlayerBanner extends Banner {

    /* renamed from: h, reason: collision with root package name */
    private FriendMusicPlayerBar f46374h;

    /* renamed from: i, reason: collision with root package name */
    private e8.b f46375i;

    /* loaded from: classes39.dex */
    class a implements e8.b {
        a() {
        }

        @Override // e8.b
        public void a(boolean z16) {
            MusicPlayerBanner musicPlayerBanner = MusicPlayerBanner.this;
            Banner.a aVar = musicPlayerBanner.f46296d;
            if (aVar != null) {
                aVar.a(z16, musicPlayerBanner.e(), MusicPlayerBanner.this.d());
            }
        }
    }

    /* loaded from: classes39.dex */
    class b implements FriendMusicPlayerBar.f {
        b() {
        }

        @Override // com.qzone.personalize.music.ui.FriendMusicPlayerBar.f
        public void a(SongInfo songInfo) {
            try {
                if (MusicPlayerBanner.this.getContext() != null) {
                    if (QZoneHelper.checkPackageInstalled(MusicPlayerBanner.this.getContext(), QZoneHelper.PACKAGENAME_QQMUSIC)) {
                        String config = QzoneConfig.getInstance().getConfig("Schema", QzoneConfig.SECONDARY_DOWNSONG_QQMUSIC, "androidqqmusic://from=html5page&mid=23&k1=0&k2={songID}");
                        Intent intent = new Intent();
                        String replace = config.replace("{songID}", String.valueOf(songInfo.f251867d));
                        intent.setData(Uri.parse(replace));
                        intent.setPackage(QZoneHelper.PACKAGENAME_QQMUSIC);
                        if (QZLog.isColorLevel()) {
                            QZLog.d("MusicPlayerBanner", 2, "download song :" + replace);
                        }
                        MusicPlayerBanner.this.getContext().startActivity(intent);
                        return;
                    }
                    yo.d.e(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_DOWN_QQMUSIC_CLIENT, "https://y.qq.com/m/download/index.html"), MusicPlayerBanner.this.getContext(), null, null);
                }
            } catch (Throwable th5) {
                QZLog.e("MusicPlayerBanner", "exception on click.", th5);
            }
        }

        @Override // com.qzone.personalize.music.ui.FriendMusicPlayerBar.f
        public void onClose() {
            MusicPlayerBanner.this.f46298f = false;
        }
    }

    public MusicPlayerBanner(Context context) {
        super(context);
        this.f46375i = new a();
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 32;
    }

    @Override // com.qzone.component.banner.Banner
    public void destroy() {
        this.f46374h.M();
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 4;
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        FriendMusicPlayerBar friendMusicPlayerBar = (FriendMusicPlayerBar) f.a().c().j(getContext(), this.f46375i);
        this.f46374h = friendMusicPlayerBar;
        if (friendMusicPlayerBar == null) {
            return;
        }
        friendMusicPlayerBar.setOnMusicBarClickListener(new b());
        addView(this.f46374h);
        this.f46374h.setVisibility(8);
        setVisibility(8);
        this.f46297e = true;
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
        if (this.f46297e) {
            if (z16 && !this.f46298f) {
                this.f46298f = true;
                ClickReport.r("", "", "", true, "427", "1", "1", "", this.f46374h.O());
            }
            this.f46374h.setVisibility(z16 ? 0 : 8);
            setVisibility(z16 ? 0 : 8);
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        return this.f46297e && getVisibility() == 0 && this.f46374h.getVisibility() == 0;
    }

    public void setPageUin(long j3) {
        this.f46374h.setPageUin(j3);
    }

    public void u() {
        this.f46374h.P();
    }

    public void v(CustomPlayerData customPlayerData) {
        this.f46374h.V(customPlayerData);
    }

    public MusicPlayerBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f46375i = new a();
    }

    @Override // com.qzone.component.banner.Banner
    public void t(com.qzone.feed.business.model.a aVar) {
    }
}

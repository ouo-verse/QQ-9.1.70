package com.tencent.mobileqq.tvideo.danmaku.manager;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.danmaku.model.VideoDmSwitchData;
import com.tencent.mobileqq.tvideo.danmaku.protocol.VideoDmSwitchResponse;
import com.tencent.mobileqq.tvideo.danmaku.vm.VideoDmSwitchViewModel;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import tvideo.Video;
import tvideo.VideoBaseInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class n {

    /* renamed from: c, reason: collision with root package name */
    public static volatile n f304412c;

    /* renamed from: a, reason: collision with root package name */
    private int f304413a = -1;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, VideoDmSwitchData> f304414b;

    n() {
    }

    public static n b() {
        if (f304412c == null) {
            synchronized (n.class) {
                if (f304412c == null) {
                    f304412c = new n();
                }
            }
        }
        return f304412c;
    }

    public static boolean f() {
        return qx2.a.c().k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(Video video, BaseRequest baseRequest, boolean z16, long j3, String str, VideoDmSwitchResponse videoDmSwitchResponse) {
        VideoDmSwitchData videoDmSwitchData;
        VideoBaseInfo videoBaseInfo = video.video_base_info;
        if (videoBaseInfo != null && !TextUtils.isEmpty(videoBaseInfo.vid) && videoDmSwitchResponse != null && (videoDmSwitchData = videoDmSwitchResponse.data) != null) {
            this.f304414b.put(video.video_base_info.vid, videoDmSwitchData);
        }
    }

    private void i(final Video video) {
        new VideoDmSwitchViewModel(video).m2(new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.tvideo.danmaku.manager.m
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                n.this.h(video, baseRequest, z16, j3, str, (VideoDmSwitchResponse) obj);
            }
        });
    }

    public boolean c(Video video) {
        if (!d() || !e() || !g(video)) {
            return false;
        }
        return true;
    }

    public boolean d() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tvideo_danmu_enable", true);
    }

    public boolean e() {
        if (this.f304413a == -1) {
            this.f304413a = uq3.k.a().e("sp_key_danmaku_enable", iy2.a.b("exp_ug_qqoa_danmu_switch20230428", "is_open"));
            QLog.i("TVideoSwitchConfigManager", 1, "[isBarrageOpen]  first time, sBarrageSwitch = " + this.f304413a);
        }
        if (this.f304413a == 1) {
            return true;
        }
        return false;
    }

    public boolean g(Video video) {
        if (video == null) {
            return false;
        }
        if (this.f304414b == null) {
            this.f304414b = new HashMap();
        }
        VideoDmSwitchData videoDmSwitchData = this.f304414b.get("");
        if (videoDmSwitchData != null) {
            if (videoDmSwitchData.opened != 1) {
                return false;
            }
            return true;
        }
        i(video);
        return true;
    }

    public void j() {
        if (e()) {
            this.f304413a = 0;
        } else {
            this.f304413a = 1;
        }
        uq3.k.a().m("sp_key_danmaku_enable", this.f304413a);
    }
}

package com.tencent.mobileqq.guild.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.api.IGuildAdapterService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildAdapterServiceImpl implements IGuildAdapterService {
    private AppRuntime app;
    private GPServiceObserver mGPServiceObserver = new a();
    private String visitorGuildId;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(String str, int i3) {
            if (str.equals(GuildAdapterServiceImpl.this.visitorGuildId)) {
                GuildAdapterServiceImpl.this.setVisitorGuildCardInfo(null, null, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(String str) {
            if (str.equals(GuildAdapterServiceImpl.this.visitorGuildId)) {
                GuildAdapterServiceImpl.this.setVisitorGuildCardInfo(null, null, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(String str) {
            if (str.equals(GuildAdapterServiceImpl.this.visitorGuildId)) {
                GuildAdapterServiceImpl.this.setVisitorGuildCardInfo(null, null, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(String str) {
            if (str.equals(GuildAdapterServiceImpl.this.visitorGuildId)) {
                GuildAdapterServiceImpl.this.setVisitorGuildCardInfo(null, null, null);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildAdapterService
    public List<IGProChannelInfo> getChannelList(String str, boolean z16) {
        IGProChannelInfo iGProChannelInfo;
        if (this.app != null && !TextUtils.isEmpty(str)) {
            List<IGProChannelInfo> channelList = ((IGPSService) this.app.getRuntimeService(IGPSService.class, "")).getChannelList(str);
            Iterator<IGProChannelInfo> it = channelList.iterator();
            while (true) {
                if (it.hasNext()) {
                    iGProChannelInfo = it.next();
                    if (iGProChannelInfo.getType() == 3) {
                        break;
                    }
                } else {
                    iGProChannelInfo = null;
                    break;
                }
            }
            ArrayList arrayList = new ArrayList(channelList);
            if (iGProChannelInfo != null) {
                arrayList.remove(iGProChannelInfo);
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildAdapterService
    @Deprecated
    public HashMap<String, List<IGProChannelInfo>> getChannelMap(String str, boolean z16) {
        List<IGProChannelInfo> channelList = getChannelList(str, z16);
        HashMap<String, List<IGProChannelInfo>> hashMap = new HashMap<>();
        hashMap.put("", channelList);
        hashMap.put("\u5206\u7ec41", channelList);
        hashMap.put("\u5206\u7ec42", channelList);
        return hashMap;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildAdapterService
    public IGProGlobalBanner getGuildBanner(String str, int i3) {
        if (this.app == null || TextUtils.isEmpty(str)) {
            return null;
        }
        if (i3 != 1 && i3 != 0) {
            return null;
        }
        return ((IGPSService) this.app.getRuntimeService(IGPSService.class, "")).getGuildGlobalBanner(str);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.app = appRuntime;
        ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).addObserver(this.mGPServiceObserver);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        ((IGPSService) this.app.getRuntimeService(IGPSService.class, "")).deleteObserver(this.mGPServiceObserver);
        setVisitorGuildCardInfo(null, null, null);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildAdapterService
    public void setVisitorGuildCardInfo(String str, IGProGuildInfo iGProGuildInfo, List<cy> list) {
        this.visitorGuildId = str;
    }
}

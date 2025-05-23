package com.tencent.mobileqq.guild.media.pic.config.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildPicPreDownLoadApi extends IRuntimeService {
    public static final String GUILD_PIC_LOG_TAG = "<gld>";

    boolean isPreDownLoadWhenScrollView();

    boolean isUsing720Flag();

    boolean isUsingHttps();

    int preDownLoadImageCountWhenScrollView();

    int preDownLoadMsgCountWhenScrollView();
}

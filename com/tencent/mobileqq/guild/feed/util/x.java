package com.tencent.mobileqq.guild.feed.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vfs.IVFSAssistantApi;

/* compiled from: P */
/* loaded from: classes13.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public static final float f223928a = ViewUtils.dpToPx(225.0f);

    /* renamed from: b, reason: collision with root package name */
    private static final String f223929b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f223930c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f223931d;

    static {
        String sDKPrivatePath = ((IVFSAssistantApi) QRoute.api(IVFSAssistantApi.class)).getSDKPrivatePath("guildFeed/");
        f223929b = sDKPrivatePath;
        String str = sDKPrivatePath + ProtocolDownloaderConstants.FILE_PREFIX;
        f223930c = str;
        f223931d = str + "download/";
    }
}

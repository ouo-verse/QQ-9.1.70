package com.tencent.mobileqq.guild.temp.api;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildMakeQQFriendApi extends QRouteApi {
    public static final int ADD_FRIEND_SCENE_INBOX = 1;
    public static final int ADD_FRIEND_SCENE_PROFILE = 2;
    public static final int APP_ID = 102012332;
    public static final int SGRP_SCENE_ID_GRAY_TIP = 1;
    public static final int SGRP_SCENE_ID_INBOX = 3;
    public static final int SGRP_SCENE_ID_PROFILE = 2;
    public static final int SUB_SOURCE_GUILD = 3;
    public static final String TAG = "IGuildMakeQQFriendApi";

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f235218a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f235219b = "1";

        /* renamed from: c, reason: collision with root package name */
        public String f235220c = "1";

        /* renamed from: d, reason: collision with root package name */
        public String f235221d = "1";

        /* renamed from: e, reason: collision with root package name */
        public int f235222e = 0;

        /* renamed from: f, reason: collision with root package name */
        public String f235223f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f235224g = "";

        /* renamed from: h, reason: collision with root package name */
        public int f235225h = 0;

        /* renamed from: i, reason: collision with root package name */
        public String f235226i = "";

        /* renamed from: j, reason: collision with root package name */
        public String f235227j = "";

        /* renamed from: k, reason: collision with root package name */
        public String f235228k = "";

        /* renamed from: l, reason: collision with root package name */
        public int f235229l;

        public String a() {
            return this.f235218a + ContainerUtils.FIELD_DELIMITER + this.f235219b + ContainerUtils.FIELD_DELIMITER + this.f235220c + ContainerUtils.FIELD_DELIMITER + this.f235221d + ContainerUtils.FIELD_DELIMITER + this.f235222e + ContainerUtils.FIELD_DELIMITER + this.f235223f + ContainerUtils.FIELD_DELIMITER + this.f235224g + ContainerUtils.FIELD_DELIMITER + this.f235225h;
        }
    }

    void makeQQFriend(Context context, a aVar);
}

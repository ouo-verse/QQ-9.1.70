package com.tencent.gamematrix.gmcg.sdk.service;

import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGUserQueueResp {
    public List<GameWaitInfo> data;

    /* renamed from: msg, reason: collision with root package name */
    public String f107907msg;
    public int ret;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class GameWaitInfo {
        public String bizInfo;
        public String tag;
        public String waitid;
        public int waitnum;
        public int waitpos;
        public int waitsec;

        public GameWaitInfo() {
        }
    }
}

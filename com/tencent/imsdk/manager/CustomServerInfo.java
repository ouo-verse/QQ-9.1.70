package com.tencent.imsdk.manager;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class CustomServerInfo {
    public List<ServerAddress> longconnectionAddressList = new ArrayList();
    public List<ServerAddress> shortconnectionAddressList = new ArrayList();
    public String serverPublicKey = "";

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class ServerAddress {

        /* renamed from: ip, reason: collision with root package name */
        public String f116752ip = "";
        public int port = 0;
        public boolean isIPv6 = false;
    }
}

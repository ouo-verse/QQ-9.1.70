package com.tencent.gamematrix.gmcg.sdk.service;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGGetIpAddressResp {
    public String carrier;
    public String client_ip;
    private List<GatewayBean> gateway;
    public float lost_rate_threshold;

    /* renamed from: msg, reason: collision with root package name */
    public String f107893msg;
    public String province;
    public int ret;
    public float rtt_threshold;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class GatewayBean {

        /* renamed from: ip, reason: collision with root package name */
        private String f107894ip;

        public String getIp() {
            return this.f107894ip;
        }

        public void setIp(String str) {
            this.f107894ip = str;
        }
    }

    public List<GatewayBean> getGateway() {
        if (this.gateway == null) {
            this.gateway = new ArrayList();
        }
        return this.gateway;
    }

    public String getMsg() {
        return this.f107893msg;
    }

    public int getRet() {
        return this.ret;
    }

    public void setGateway(List<GatewayBean> list) {
        this.gateway = list;
    }

    public void setMsg(String str) {
        this.f107893msg = str;
    }

    public void setRet(int i3) {
        this.ret = i3;
    }
}

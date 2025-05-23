package com.tencent.gamematrix.gmcg.sdk.service;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGMergeLaunchCloudGameResp {
    public List<DataBean> data = new ArrayList();

    /* renamed from: msg, reason: collision with root package name */
    public String f107898msg;
    public int ret;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class DataBean {
        public RespBean resp;
        public String url;

        /* compiled from: P */
        /* loaded from: classes6.dex */
        public static class RespBean {

            /* renamed from: msg, reason: collision with root package name */
            public String f107899msg;
            public int ret;

            public String toString() {
                return "RespBean{ret=" + this.ret + ", msg='" + this.f107899msg + "'}";
            }
        }

        public String toString() {
            return "DataBean{url='" + this.url + "', resp=" + this.resp + '}';
        }
    }

    public String toString() {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CGMergeLaunchCloudGameResp{ret=");
        sb5.append(this.ret);
        sb5.append(", msg='");
        sb5.append(this.f107898msg);
        sb5.append('\'');
        sb5.append(", data size=");
        List<DataBean> list = this.data;
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        sb5.append('}');
        return sb5.toString();
    }
}

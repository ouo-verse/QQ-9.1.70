package com.tencent.mobileqq.timiqqid.net.data;

import com.google.gson.annotations.SerializedName;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes18.dex */
public class PassResult implements Serializable {

    @SerializedName("body")
    private a body;

    @SerializedName("header")
    private b header;

    /* loaded from: classes18.dex */
    public static class a {

        @SerializedName("jumpChannel")
        private String jumpChannel;

        @SerializedName("jumpSceneName")
        private String jumpSceneName;

        @SerializedName(StateEvent.ActionValue.STAGE_PASS)
        private int pass;

        @SerializedName("showDialog")
        private C8653a showDialog;

        @SerializedName("status")
        private int status;

        /* renamed from: com.tencent.mobileqq.timiqqid.net.data.PassResult$a$a, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public static class C8653a {

            @SerializedName("body")
            private String body;

            @SerializedName("button")
            private C8654a button;

            @SerializedName("phoneList")
            private List<Object> phoneList;

            @SerializedName("style")
            private int style;

            @SerializedName("title")
            private String title;

            /* renamed from: com.tencent.mobileqq.timiqqid.net.data.PassResult$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes18.dex */
            public static class C8654a {

                @SerializedName(WadlProxyConsts.KEY_JUMP_URL)
                private String jumpUrl;

                @SerializedName("text")
                private String text;
            }
        }

        public String a() {
            return this.jumpChannel;
        }

        public String b() {
            return this.jumpSceneName;
        }

        public int c() {
            return this.status;
        }
    }

    /* loaded from: classes18.dex */
    public static class b {

        @SerializedName("errMsg")
        private String errMsg;

        @SerializedName("ret")
        private int ret;

        public int a() {
            return this.ret;
        }
    }

    public a getBody() {
        return this.body;
    }

    public b getHeader() {
        return this.header;
    }

    public void setBody(a aVar) {
        this.body = aVar;
    }

    public void setHeader(b bVar) {
        this.header = bVar;
    }
}

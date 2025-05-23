package com.tencent.component.media.image;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ImageDownloadInfo {
    public String clientIp;
    public String contentType;
    public String downloadDetailInfo;
    public int failCode;
    public int nocacheCode;
    public int retCode;
    public String serverIp;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class Builder {
        private String client_ip;
        private String content_type;
        public String download_detail_info;
        private int fail_code;
        public int nocache_code;
        private int ret_code;
        private String server_ip;

        public Builder(int i3, int i16) {
            this.fail_code = i3;
            this.ret_code = i16;
        }

        public ImageDownloadInfo build() {
            return new ImageDownloadInfo(this);
        }

        public Builder clientIp(String str) {
            this.client_ip = str;
            return this;
        }

        public Builder contentType(String str) {
            this.content_type = str;
            return this;
        }

        public Builder downloadDetailInfo(String str) {
            this.download_detail_info = str;
            return this;
        }

        public Builder nocacheCode(int i3) {
            this.nocache_code = i3;
            return this;
        }

        public Builder serverIp(String str) {
            this.server_ip = str;
            return this;
        }
    }

    ImageDownloadInfo(Builder builder) {
        this.failCode = builder.fail_code;
        this.retCode = builder.ret_code;
        this.contentType = builder.content_type;
        this.serverIp = builder.server_ip;
        this.clientIp = builder.client_ip;
        this.nocacheCode = builder.nocache_code;
        this.downloadDetailInfo = builder.download_detail_info;
    }
}

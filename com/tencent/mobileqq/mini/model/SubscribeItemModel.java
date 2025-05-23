package com.tencent.mobileqq.mini.model;

import NS_MINI_INTERFACE.INTERFACE$StSubscribeMessage;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SubscribeItemModel {
    private String content;
    private boolean isChecked;
    private INTERFACE$StSubscribeMessage stSubscribeMessage;
    private SubscribeViewType viewType;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class Builder {
        private String content;
        private boolean isChecked;
        private INTERFACE$StSubscribeMessage stSubscribeMessage;
        private SubscribeViewType viewType;

        public Builder() {
        }

        public SubscribeItemModel build() {
            return new SubscribeItemModel(this.viewType, this.isChecked, this.content, this.stSubscribeMessage);
        }

        public Builder setContent(String str) {
            this.content = str;
            return this;
        }

        public Builder setIsChecked(boolean z16) {
            this.isChecked = z16;
            return this;
        }

        public Builder setStSubscribeMessage(INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage) {
            this.stSubscribeMessage = iNTERFACE$StSubscribeMessage;
            return this;
        }

        public Builder setViewType(SubscribeViewType subscribeViewType) {
            this.viewType = subscribeViewType;
            return this;
        }

        public Builder(SubscribeItemModel subscribeItemModel) {
            this.viewType = subscribeItemModel.viewType;
            this.isChecked = subscribeItemModel.isChecked;
            this.content = subscribeItemModel.content;
            this.stSubscribeMessage = subscribeItemModel.stSubscribeMessage;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public enum SubscribeViewType {
        TITLE,
        LONG_TERM_SUBSCRIBE,
        ONE_TIME_SUBSCRIBE,
        INTERACTIVE_SUBSCRIBE
    }

    SubscribeItemModel(SubscribeViewType subscribeViewType, boolean z16, String str, INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage) {
        this.viewType = subscribeViewType;
        this.isChecked = z16;
        this.content = str;
        this.stSubscribeMessage = iNTERFACE$StSubscribeMessage;
    }

    public String getContent() {
        return this.content;
    }

    public INTERFACE$StSubscribeMessage getStSubscribeMessage() {
        return this.stSubscribeMessage;
    }

    public SubscribeViewType getViewType() {
        return this.viewType;
    }

    public boolean isChecked() {
        return this.isChecked;
    }
}

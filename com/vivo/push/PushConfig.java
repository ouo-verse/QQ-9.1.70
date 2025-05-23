package com.vivo.push;

/* loaded from: classes6.dex */
public class PushConfig {
    private boolean mAgreePrivacyStatement;
    private boolean mOpenMultiUser;

    /* loaded from: classes6.dex */
    public static final class Builder {
        private boolean mAgreePrivacyStatement = true;
        private boolean mOpenMultiUser = false;

        public final Builder agreePrivacyStatement(boolean z16) {
            this.mAgreePrivacyStatement = z16;
            return this;
        }

        public final PushConfig build() {
            return new PushConfig(this);
        }

        public final Builder openMultiUserMode(boolean z16) {
            this.mOpenMultiUser = z16;
            return this;
        }
    }

    public boolean isAgreePrivacyStatement() {
        return this.mAgreePrivacyStatement;
    }

    public boolean isOpenMultiUser() {
        return this.mOpenMultiUser;
    }

    PushConfig(Builder builder) {
        this.mAgreePrivacyStatement = true;
        this.mOpenMultiUser = false;
        this.mAgreePrivacyStatement = builder.mAgreePrivacyStatement;
        this.mOpenMultiUser = builder.mOpenMultiUser;
    }
}

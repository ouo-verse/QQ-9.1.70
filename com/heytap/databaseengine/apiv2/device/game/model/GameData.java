package com.heytap.databaseengine.apiv2.device.game.model;

import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class GameData {
    private int countDown;
    private int killType;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Builder {
        private int countDown;
        private int killType;

        public GameData build() {
            return new GameData(this);
        }

        public Builder setCountDown(int i3) {
            this.countDown = i3;
            return this;
        }

        public Builder setKill(int i3) {
            this.killType = i3;
            return this;
        }
    }

    public int getCountDown() {
        return this.countDown;
    }

    public int getKillType() {
        return this.killType;
    }

    GameData(Builder builder) {
        this.killType = builder.killType;
        this.countDown = builder.countDown;
    }
}

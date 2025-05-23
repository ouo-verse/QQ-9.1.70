package com.tencent.midas.api.ability;

import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MidasActivityAbility extends MidasBaseAbility {
    private static final String BUNDLE_PREFIX = "__midas_ability_activity__";
    public String action;
    public String area;
    public String partition;
    public String payItem;
    public String platId;
    public String roleId;
    public String roleName;
    public String sceneInfo;
    public AbsShare shareInfo;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class AbsQQShare extends AbsShare {
        public boolean hideQzone = false;
        public String arkJson = "";

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.hideQzone = bundle.getBoolean(MidasActivityAbility.BUNDLE_PREFIX + AbsQQShare.class.getSimpleName() + "_hideQzone");
            this.arkJson = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + AbsQQShare.class.getSimpleName() + "_arkJson");
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility
        public Bundle toBundle() {
            Bundle bundle = super.toBundle();
            bundle.putBoolean(MidasActivityAbility.BUNDLE_PREFIX + AbsQQShare.class.getSimpleName() + "_hideQzone", this.hideQzone);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + AbsQQShare.class.getSimpleName() + "_arkJson", this.arkJson);
            return bundle;
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare
        public String toString() {
            return super.toString() + "|hideQzone=" + this.hideQzone + "|arkJson=" + this.arkJson;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class AbsWXShare extends AbsShare {
        public String title = "";
        public String description = "";
        public byte[] thumbData = null;
        public int scene = 0;
        public String transaction = "";
        public String userOpenId = "";

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.title = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_title");
            this.description = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_description");
            this.thumbData = bundle.getByteArray(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_thumbData");
            this.scene = bundle.getInt(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_scene");
            this.transaction = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_transaction");
            this.userOpenId = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_userOpenId");
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility
        public Bundle toBundle() {
            Bundle bundle = super.toBundle();
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_title", this.title);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_description", this.description);
            bundle.putByteArray(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_thumbData", this.thumbData);
            bundle.putInt(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_scene", this.scene);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_transaction", this.transaction);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + AbsWXShare.class.getSimpleName() + "_userOpenId", this.userOpenId);
            return bundle;
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare
        public String toString() {
            return super.toString() + "|title=" + this.title + "|description=" + this.description + "|thumbData=" + this.thumbData + "|scene=" + this.scene + "|transaction=" + this.transaction + "|userOpenId=" + this.userOpenId;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class QQMiniProgramShare extends AbsQQShare {
        public String imageUrl;
        public String miniProgramType;
        public String summary;
        public String title;

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsQQShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.title = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + QQMiniProgramShare.class.getSimpleName() + "_title");
            this.summary = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + QQMiniProgramShare.class.getSimpleName() + "_summary");
            this.imageUrl = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + QQMiniProgramShare.class.getSimpleName() + "_imageUrl");
            this.miniProgramType = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + QQMiniProgramShare.class.getSimpleName() + "_miniProgramType");
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsQQShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility
        public Bundle toBundle() {
            Bundle bundle = super.toBundle();
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + QQMiniProgramShare.class.getSimpleName() + "_title", this.title);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + QQMiniProgramShare.class.getSimpleName() + "_summary", this.summary);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + QQMiniProgramShare.class.getSimpleName() + "_imageUrl", this.imageUrl);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + QQMiniProgramShare.class.getSimpleName() + "_miniProgramType", this.miniProgramType);
            return bundle;
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsQQShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsShare
        public String toString() {
            return super.toString() + "|title=" + this.title + "|summary=" + this.summary + "|imageUrl=" + this.imageUrl + "|miniProgramType=" + this.miniProgramType;
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare
        public int type() {
            return 2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class QQWebShare extends AbsQQShare {
        public String appName;
        public String imageUrl;
        public String summary;
        public String title;

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsQQShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.title = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + QQWebShare.class.getSimpleName() + "_title");
            this.summary = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + QQWebShare.class.getSimpleName() + "_summary");
            this.imageUrl = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + QQWebShare.class.getSimpleName() + "_imageUrl");
            this.appName = bundle.getString(MidasActivityAbility.BUNDLE_PREFIX + QQWebShare.class.getSimpleName() + "_appName");
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsQQShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility
        public Bundle toBundle() {
            Bundle bundle = super.toBundle();
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + QQWebShare.class.getSimpleName() + "_title", this.title);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + QQWebShare.class.getSimpleName() + "_summary", this.summary);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + QQWebShare.class.getSimpleName() + "_imageUrl", this.imageUrl);
            bundle.putString(MidasActivityAbility.BUNDLE_PREFIX + QQWebShare.class.getSimpleName() + "_appName", this.appName);
            return bundle;
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsQQShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsShare
        public String toString() {
            return super.toString() + "|title=" + this.title + "|summary=" + this.summary + "|imageUrl=" + this.imageUrl + "|appName=" + this.appName;
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare
        public int type() {
            return 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class WXMiniProgramShare extends AbsWXShare {
        public int miniprogramType;
        public boolean withShareTicket;

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsWXShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.withShareTicket = bundle.getBoolean(MidasActivityAbility.BUNDLE_PREFIX + WXMiniProgramShare.class.getSimpleName() + "_withShareTicket");
            this.miniprogramType = bundle.getInt(MidasActivityAbility.BUNDLE_PREFIX + WXMiniProgramShare.class.getSimpleName() + "_miniprogramType");
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsWXShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility
        public Bundle toBundle() {
            Bundle bundle = super.toBundle();
            bundle.putBoolean(MidasActivityAbility.BUNDLE_PREFIX + WXMiniProgramShare.class.getSimpleName() + "_withShareTicket", this.withShareTicket);
            bundle.putInt(MidasActivityAbility.BUNDLE_PREFIX + WXMiniProgramShare.class.getSimpleName() + "_miniprogramType", this.miniprogramType);
            return bundle;
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsWXShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsShare
        public String toString() {
            return super.toString() + "|withShareTicket=" + this.withShareTicket + "|miniprogramType=" + this.miniprogramType;
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare
        public int type() {
            return 4;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class WXWebShare extends AbsWXShare {
        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsWXShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsWXShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsShare, com.tencent.midas.api.ability.IMidasAbility
        public Bundle toBundle() {
            return super.toBundle();
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsWXShare, com.tencent.midas.api.ability.MidasActivityAbility.AbsShare
        public String toString() {
            return super.toString();
        }

        @Override // com.tencent.midas.api.ability.MidasActivityAbility.AbsShare
        public int type() {
            return 3;
        }
    }

    @Override // com.tencent.midas.api.ability.MidasBaseAbility, com.tencent.midas.api.ability.IMidasAbility
    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.payItem = bundle.getString("__midas_ability_activity__payItem");
        this.area = bundle.getString("__midas_ability_activity__area");
        this.platId = bundle.getString("__midas_ability_activity__platId");
        this.partition = bundle.getString("__midas_ability_activity__partition");
        this.roleId = bundle.getString("__midas_ability_activity__roleId");
        this.roleName = bundle.getString("__midas_ability_activity__roleName");
        this.action = bundle.getString("__midas_ability_activity__action");
        this.sceneInfo = bundle.getString("__midas_ability_activity__sceneInfo");
        Bundle bundle2 = bundle.getBundle("__midas_ability_activity__shareInfo");
        if (bundle2 != null) {
            this.shareInfo = AbsShare.createChild(bundle2);
        }
    }

    @Override // com.tencent.midas.api.ability.MidasBaseAbility, com.tencent.midas.api.ability.IMidasAbility
    public Bundle toBundle() {
        Bundle bundle = super.toBundle();
        bundle.putString("__midas_ability_activity__payItem", this.payItem);
        bundle.putString("__midas_ability_activity__area", this.area);
        bundle.putString("__midas_ability_activity__platId", this.platId);
        bundle.putString("__midas_ability_activity__partition", this.partition);
        bundle.putString("__midas_ability_activity__roleId", this.roleId);
        bundle.putString("__midas_ability_activity__roleName", this.roleName);
        bundle.putString("__midas_ability_activity__action", this.action);
        bundle.putString("__midas_ability_activity__sceneInfo", this.sceneInfo);
        AbsShare absShare = this.shareInfo;
        if (absShare != null) {
            bundle.putBundle("__midas_ability_activity__shareInfo", absShare.toBundle());
        }
        return bundle;
    }

    @Override // com.tencent.midas.api.ability.MidasBaseAbility
    public String toString() {
        return super.toString() + "|payItem=" + this.payItem + "|area=" + this.area + "|platId=" + this.platId + "|partition=" + this.partition + "|roleId=" + this.roleId + "|roleName=" + this.roleName + "|action=" + this.action + "|sceneInfo=" + this.sceneInfo + "|shareInfo=" + this.shareInfo;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class AbsShare implements IMidasAbility {
        protected static final String TYPE_KEY = "shareType";
        protected static final int TYPE_QQ_MINIPROGRAM = 2;
        protected static final int TYPE_QQ_WEB = 1;
        protected static final int TYPE_WX_MINIPROGRAM = 4;
        protected static final int TYPE_WX_WEB = 3;

        public static AbsShare createChild(Bundle bundle) {
            int i3 = bundle.getInt("__midas_ability_activity__shareType");
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return null;
                        }
                        WXMiniProgramShare wXMiniProgramShare = new WXMiniProgramShare();
                        wXMiniProgramShare.fromBundle(bundle);
                        return wXMiniProgramShare;
                    }
                    WXWebShare wXWebShare = new WXWebShare();
                    wXWebShare.fromBundle(bundle);
                    return wXWebShare;
                }
                QQMiniProgramShare qQMiniProgramShare = new QQMiniProgramShare();
                qQMiniProgramShare.fromBundle(bundle);
                return qQMiniProgramShare;
            }
            QQWebShare qQWebShare = new QQWebShare();
            qQWebShare.fromBundle(bundle);
            return qQWebShare;
        }

        @Override // com.tencent.midas.api.ability.IMidasAbility
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt("__midas_ability_activity__shareType", type());
            return bundle;
        }

        public String toString() {
            return "shareType=" + type();
        }

        abstract int type();

        @Override // com.tencent.midas.api.ability.IMidasAbility
        public void fromBundle(Bundle bundle) {
        }
    }
}

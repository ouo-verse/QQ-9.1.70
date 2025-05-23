package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* loaded from: classes19.dex */
public class QAdVrReportParams extends com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.a {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface ClickAdActionTypeValue {
        public static final String ACTION_TYPE_NO_JUMP = "109";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface InstallResult {
        public static final String INSTALLED = "1";
        public static final String UNINSTALLED = "0";
    }

    /* loaded from: classes19.dex */
    public @interface MediaValue {
        public static final String PIAN_DUO_DUO = "pianduoduo";
        public static final String SPORTS = "sports";
        public static final String VIDEO = "video";
    }

    /* loaded from: classes19.dex */
    public @interface ParamKey {
        public static final String AD_ACTION_TYPE = "ad_act_type";
        public static final String AD_ACTION_TYPE_TRUE = "ad_action_type";
        public static final String AD_GROUP_ID = "ad_group_id";
        public static final String AD_IDX = "ad_idx";
        public static final String AD_LAYER = "ad_layer";
        public static final String AD_NUM_ALL = "ad_num_all";
        public static final String AD_NUM_CUMULATIVE = "ad_num_cumulative";
        public static final String AD_NUM_CURRENT = "ad_num_current";
        public static final String AD_POP_LOCK_TIME = "ad_popup_lock_time";
        public static final String AD_PULL_TYPE = "ad_pull_type";
        public static final String AD_SHOW_TYPE = "ad_show_type";
        public static final String AD_TYPE = "ad_type";
        public static final String AD_UNLOCK_CID = "ad_unlock_cid";
        public static final String AD_UNLOCK_VID = "ad_unlock_vid";
        public static final String BUSINESS = "business";
        public static final String CID = "cid";
        public static final String CRE_PG = "cre_pg";
        public static final String CUR_PG = "cur_pg";
        public static final String EID = "eid";
        public static final String EXPERIMENT_ID = "experiment_id";
        public static final String HAP_LINK_SCENE = "haplink_scene";
        public static final String IS_AD_VID = "is_ad_vid";
        public static final String IS_FULLSCREEN = "is_fullscreen";
        public static final String IS_OVERLAY = "is_overlay";
        public static final String IS_UNLOCK = "is_unlock";
        public static final String LID = "lid";
        public static final String MEDIA = "media";
        public static final String PGID = "pgid";
        public static final String PG_CID = "pg_cid";
        public static final String PG_LID = "pg_lid";
        public static final String PG_TYPE = "pg_type";
        public static final String PG_TYPE_ID = "pg_type_id";
        public static final String PG_VID = "pg_vid";
        public static final String PLAYBOX_TYPE = "playbox_type";
        public static final String REF_ELE = "ref_ele";
        public static final String REF_PG = "ref_pg";
        public static final String SOUND_STATUS = "status";
        public static final String STYLE_TYPE = "styletype";
        public static final String TIME_COST = "time_cost";
        public static final String VID = "vid";
        public static final String VR_PAGE_ID = "vr_page_id";
        public static final String ZTID = "ztid";
    }

    /* loaded from: classes19.dex */
    public @interface ParamValue {
        public static final String BUSINESS = "ad";
        public static final String DEEPLINK = "deeplink";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface RewardAdUnlockState {
        public static final int NOT_UNLOCK = 0;
        public static final int UNLOCKED = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface SoundStatusResult {
        public static final int MUTE = 1;
        public static final int UN_MUTE = 0;
    }

    /* loaded from: classes19.dex */
    public static class a extends a.C8855a {
        public a d(int i3) {
            super.a(ParamKey.AD_LAYER, String.valueOf(i3));
            return this;
        }

        public a e(int i3) {
            super.a(ParamKey.AD_ACTION_TYPE, String.valueOf(i3));
            return this;
        }

        public a f(String str, Object obj) {
            super.a(str, obj);
            return this;
        }

        public a g(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.a aVar) {
            super.b(aVar);
            return this;
        }

        public a h(Map<String, ?> map) {
            super.c(map);
            return this;
        }

        public QAdVrReportParams i() {
            QAdVrReportParams qAdVrReportParams = new QAdVrReportParams();
            qAdVrReportParams.g(this.f304025a);
            return qAdVrReportParams;
        }
    }

    public void f(String str, Object obj) {
        super.a(str, obj);
    }

    public void g(Map<String, ?> map) {
        super.b(map);
    }

    public Map<String, Object> h() {
        return super.d();
    }

    public a i() {
        a aVar = new a();
        aVar.f304025a.putAll(this.f304024a);
        return aVar;
    }
}

package com.tencent.weiyun.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UserItem extends CNativeObject {
    static IPatchRedirector $redirector_;
    public String agreementUrl;
    public String avatarUrl;
    public int dirLevelMax;
    public int fileNameMaxLen;
    public int filePathMaxLen;
    public boolean flashClickEnable;
    public long flashDuration;
    public long flashEndTime;
    public String flashImageUrl;
    public long flashStarTime;
    public String flashTargetUrl;
    public String helpUrl;
    public String mainDirKey;
    public int maxBatchDirClearNum;
    public int maxBatchDirDeleteNum;
    public int maxBatchDirMoveNum;
    public int maxBatchDirRestoreNum;
    public int maxBatchFileClearNum;
    public int maxBatchFileDeleteNum;
    public int maxBatchFileMoveNum;
    public int maxBatchFileRestoreNum;
    public String name;
    public boolean oldWeiyunVip;
    public long pluginSwitchFlag;
    public String pwdForgetUrl;
    public boolean pwdOpen;
    public String qqOfflineDetailUrl;
    public String recommendationUrl;
    public long serverTime;
    public long superVipEndTime;
    public long totalSpace;
    private long uin;
    public long usedSpace;
    public long vipEndTime;
    public boolean weiyunSuperVip;
    public boolean weiyunVip;

    UserItem() {
        super(0L);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static UserItem newInstance(long j3) {
        if (j3 == 0) {
            return null;
        }
        UserItem userItem = new UserItem(j3);
        userItem.uin = CBundleReader.getLong(j3, "uin", 0L);
        userItem.name = CBundleReader.getString(j3, "name");
        userItem.avatarUrl = CBundleReader.getString(j3, "avatar");
        userItem.mainDirKey = CBundleReader.getHexString(j3, "main_dir_key");
        userItem.totalSpace = CBundleReader.getLong(j3, "total_space", 0L);
        userItem.usedSpace = CBundleReader.getLong(j3, "used_space", 0L);
        userItem.pwdOpen = CBundleReader.getBoolean(j3, "pwd_open", false);
        userItem.weiyunVip = CBundleReader.getBoolean(j3, "weiyun_vip", false);
        userItem.oldWeiyunVip = CBundleReader.getBoolean(j3, "old_weiyun_vip", false);
        userItem.vipEndTime = CBundleReader.getLong(j3, "vip_end_time", 0L);
        userItem.weiyunSuperVip = CBundleReader.getBoolean(j3, "is_weiyun_super_vip", false);
        userItem.superVipEndTime = CBundleReader.getLong(j3, "super_vip_end_time", 0L);
        userItem.filePathMaxLen = CBundleReader.getInt(j3, "file_path_max_len", 0);
        userItem.fileNameMaxLen = CBundleReader.getInt(j3, "file_name_max_len", 0);
        userItem.dirLevelMax = CBundleReader.getInt(j3, "dir_level_max", 0);
        userItem.maxBatchDirDeleteNum = CBundleReader.getInt(j3, "max_batch_dir_delete_num", 0);
        userItem.maxBatchFileDeleteNum = CBundleReader.getInt(j3, "max_batch_file_delete_num", 0);
        userItem.maxBatchDirMoveNum = CBundleReader.getInt(j3, "max_batch_dir_move_num", 0);
        userItem.maxBatchFileMoveNum = CBundleReader.getInt(j3, "max_batch_file_move_num", 0);
        userItem.maxBatchDirRestoreNum = CBundleReader.getInt(j3, "max_batch_dir_restore_num", 0);
        userItem.maxBatchFileRestoreNum = CBundleReader.getInt(j3, "max_batch_file_restore_num", 0);
        userItem.maxBatchDirClearNum = CBundleReader.getInt(j3, "max_batch_dir_clear_num", 0);
        userItem.maxBatchFileClearNum = CBundleReader.getInt(j3, "max_batch_file_clear_num", 0);
        userItem.serverTime = CBundleReader.getLong(j3, "server_time", 0L);
        userItem.flashStarTime = CBundleReader.getLong(j3, "flash_start_time", 0L);
        userItem.flashEndTime = CBundleReader.getLong(j3, "flash_end_time", 0L);
        userItem.flashImageUrl = CBundleReader.getString(j3, "flash_image_url");
        userItem.flashClickEnable = CBundleReader.getBoolean(j3, "flash_click_enable", false);
        userItem.flashTargetUrl = CBundleReader.getString(j3, "flash_target_url");
        userItem.flashDuration = CBundleReader.getLong(j3, "flash_duration", 0L);
        userItem.qqOfflineDetailUrl = CBundleReader.getString(j3, "qq_offline_detail_url");
        userItem.helpUrl = CBundleReader.getString(j3, "help_url");
        userItem.recommendationUrl = CBundleReader.getString(j3, "app_recommendation_url");
        userItem.pwdForgetUrl = CBundleReader.getString(j3, "pwd_forget_url");
        userItem.agreementUrl = CBundleReader.getString(j3, "agreement_url");
        userItem.pluginSwitchFlag = CBundleReader.getLong(j3, "plugin_switch_flag", 0L);
        userItem.releaseNative();
        return userItem;
    }

    @Override // com.tencent.weiyun.data.CNativeObject
    public /* bridge */ /* synthetic */ void releaseNative() {
        super.releaseNative();
    }

    public long uin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.uin;
    }

    UserItem(long j3) {
        super(j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, j3);
    }
}

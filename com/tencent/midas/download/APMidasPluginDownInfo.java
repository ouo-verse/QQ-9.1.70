package com.tencent.midas.download;

/* loaded from: classes9.dex */
public class APMidasPluginDownInfo {
    public String split_download_url;
    public String new_md5_encode = "";
    public String new_md5_decode = "";
    public String name = "";
    public int size = 0;
    public int fullsize = 0;
    public String down_url = "";
    public String full_url = "";
    public boolean is_split = false;
    public boolean is_force = false;
    public String old_md5 = "";
    public String diff_md5 = "";
    public int update_version = 0;

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof APMidasPluginDownInfo)) {
            return false;
        }
        return this.name.equals(((APMidasPluginDownInfo) obj).name);
    }

    public int hashCode() {
        String str = this.name;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }
}

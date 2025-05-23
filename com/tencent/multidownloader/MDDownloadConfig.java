package com.tencent.multidownloader;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes34.dex */
public class MDDownloadConfig {
    public ArrayList<String> custom_headers;
    public String filename;
    public String full_save_path;
    public String md5_check;
    public String referer;
    public String save_dir;
    public boolean support_range = true;
    public int range_size = 4194304;
    public int priority = MDDownloadPriority.PRIORITY_NORMAL.ordinal();
    public boolean lifo = false;
    public boolean need_ip_resolve = true;
}

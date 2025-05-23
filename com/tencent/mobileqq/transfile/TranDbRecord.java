package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public interface TranDbRecord {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class PicDbRecord {
        static IPatchRedirector $redirector_;
        public String bigMsgUrl;
        public String bigThumbMsgUrl;
        public int extraFlag;
        public Object extraObject;
        public int fileSizeFlag;
        public boolean isRead;
        public String md5;
        public long msgId;
        public String path;
        public String rawMsgUrl;
        public String serverStoreSource;
        public long size;
        public String thumbMsgUrl;
        public int type;
        public String uin;
        public int uinType;
        public String uuid;

        public PicDbRecord() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static String makeDbRecord(String str, long j3, int i3, boolean z16, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i16, int i17) {
            return TransfileUtile.makeTransFileProtocolData(str, j3, i3, z16, str2, str3, str4, str5, str6, str7, str8, i16, i17);
        }

        public void initFromMsg(String str) {
            String[] split;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            if (str != null && str.length() > 0 && str.charAt(0) == 22 && (split = str.split("\\|")) != null) {
                for (int i3 = 0; i3 < split.length; i3++) {
                    String str2 = split[i3];
                    if (str2 != null && str2.equals("null")) {
                        split[i3] = null;
                    }
                }
                if (split.length >= 1) {
                    this.path = split[0].trim();
                }
                if (split.length >= 2) {
                    try {
                        this.size = Long.parseLong(split[1]);
                    } catch (NumberFormatException e16) {
                        this.size = 0L;
                        e16.printStackTrace();
                    }
                }
                if (split.length >= 3) {
                    try {
                        this.type = Integer.parseInt(split[2]);
                    } catch (NumberFormatException e17) {
                        this.type = 0;
                        e17.printStackTrace();
                    }
                }
                if (split.length >= 4) {
                    try {
                        this.isRead = Boolean.parseBoolean(split[3]);
                    } catch (Exception e18) {
                        this.isRead = false;
                        e18.printStackTrace();
                    }
                }
                if (split.length >= 5) {
                    this.uuid = split[4];
                }
                if (split.length >= 6) {
                    this.md5 = split[5];
                }
                if (split.length >= 7) {
                    this.serverStoreSource = split[6];
                }
                if (split.length >= 8) {
                    this.thumbMsgUrl = split[7];
                }
                if (split.length >= 9) {
                    this.bigMsgUrl = split[8];
                }
                if (split.length >= 10) {
                    this.rawMsgUrl = split[9];
                }
                if (split.length >= 11) {
                    try {
                        this.fileSizeFlag = Integer.parseInt(split[10]);
                    } catch (Exception e19) {
                        this.fileSizeFlag = 0;
                        e19.printStackTrace();
                    }
                }
                if (split.length >= 12) {
                    try {
                        this.extraFlag = Integer.parseInt(split[11]);
                    } catch (Exception e26) {
                        this.extraFlag = 0;
                        e26.printStackTrace();
                    }
                }
                if (this.extraFlag == 10) {
                    PicFowardDbRecordData picFowardDbRecordData = new PicFowardDbRecordData();
                    picFowardDbRecordData.initFromMsg(str);
                    this.extraObject = picFowardDbRecordData;
                }
            }
        }

        public static String makeDbRecord(String str, long j3, int i3, boolean z16, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i16, int i17, String str9) {
            return TransfileUtile.makeTransFileProtocolData(str, j3, i3, z16, str2, str3, str4, str5, str6, str7, str8, i16, i17, str9);
        }
    }
}

package com.tencent.mobileqq.fts.v1;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.utils.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class FTSEntity {
    static IPatchRedirector $redirector_ = null;
    public static final int EXT1_INDEX = 1;
    public static final int EXT2_INDEX = 2;
    public static final int EXT3_INDEX = 3;
    public static final int EXT_NON_INDEX = 0;
    public static final int FTS_OPT_DELETE = 16;
    public static final int FTS_OPT_INSERT = 1;
    public static final int FTS_OPT_NON = 0;
    public static final int FTS_OPT_UPDATE = 17;
    public static final int FTS_TYPE_MSG = 1;
    public static final int FTS_TYPE_NULL = 0;
    public static final int FTS_TYPE_TROOP = 2;
    public static final int MAX_LIMIT = 2000;
    public static final int MAX_PROXIMITY = 65535;
    public static final int MIN_PROXIMITY = 0;
    public String mContent;
    protected String mContentIndex;
    public String mExt1;
    public String mExt2;
    public String mExt3;
    public String mExt4;
    public String mExt5;
    public String mExt6;
    public String mExt7;
    public String mExt8;
    public String mExt9;
    public byte[] mExts;
    public long mOId;
    public int mOpt;
    public int mProximity;
    public int mProximityEnd;
    public int mProximityStart;
    public int mSearchScene;
    public int mSegmentCount;
    public int mType;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class FTSNull extends FTSEntity {
        static IPatchRedirector $redirector_;

        public FTSNull() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.fts.v1.FTSEntity
        public String createDeleteSQL() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.fts.v1.FTSEntity
        public String createInsertSQL() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.fts.v1.FTSEntity
        public String createUpdateSQL() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.fts.v1.FTSEntity
        protected void doDeserialize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.fts.v1.FTSEntity
        protected void doSerialize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.fts.v1.FTSEntity
        public String getTableName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.fts.v1.FTSEntity
        public int type() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 0;
        }
    }

    public FTSEntity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mOpt = 0;
        this.mType = -1;
        this.mContent = null;
        this.mContentIndex = null;
        this.mOId = -1L;
        this.mExt1 = null;
        this.mExt2 = null;
        this.mExt3 = null;
        this.mExt4 = null;
        this.mExt5 = null;
        this.mExt6 = null;
        this.mExt7 = null;
        this.mExt8 = null;
        this.mExt9 = null;
        this.mExts = null;
        this.mProximity = 65535;
        this.mProximityStart = -1;
        this.mProximityEnd = -1;
        this.mSegmentCount = 0;
    }

    public abstract String createDeleteSQL();

    public abstract String createInsertSQL();

    public abstract String createUpdateSQL();

    public void deleteOpt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mOpt = 16;
        }
    }

    protected abstract void doDeserialize();

    protected abstract void doSerialize();

    public abstract String getTableName();

    public void insertOpt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mOpt = 1;
        }
    }

    public void postRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            doDeserialize();
        }
    }

    public void postWrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    public void preRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public void preWrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        String str = this.mContent;
        if (str != null && !TextUtils.isEmpty(str)) {
            String d16 = a.d(this.mContent);
            this.mContentIndex = d16;
            this.mSegmentCount += a.c(d16);
        } else {
            this.mContentIndex = null;
        }
        doSerialize();
    }

    public void preWriteOne() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        String str = this.mContent;
        if (str != null && !TextUtils.isEmpty(str)) {
            String d16 = a.d(this.mContent);
            this.mContentIndex = d16;
            this.mSegmentCount += a.c(d16);
            return;
        }
        this.mContentIndex = null;
    }

    public void preWriteTwo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            doSerialize();
        }
    }

    public abstract int type();

    public void upgradeOpt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mOpt = 17;
        }
    }

    public FTSEntity(int i3, String str, long j3, String str2, String str3, String str4, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Long.valueOf(j3), str2, str3, str4, bArr);
            return;
        }
        this.mOpt = 0;
        this.mContentIndex = null;
        this.mExt4 = null;
        this.mExt5 = null;
        this.mExt6 = null;
        this.mExt7 = null;
        this.mExt8 = null;
        this.mExt9 = null;
        this.mProximity = 65535;
        this.mProximityStart = -1;
        this.mProximityEnd = -1;
        this.mSegmentCount = 0;
        this.mType = i3;
        this.mContent = str;
        this.mOId = j3;
        this.mExt1 = str2;
        this.mExt2 = str3;
        this.mExt3 = str4;
        this.mExts = bArr;
    }

    public FTSEntity(int i3, int i16, int i17, int i18, String str, long j3, String str2, String str3, String str4, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), str, Long.valueOf(j3), str2, str3, str4, bArr);
            return;
        }
        this.mOpt = 0;
        this.mContentIndex = null;
        this.mExt4 = null;
        this.mExt5 = null;
        this.mExt6 = null;
        this.mExt7 = null;
        this.mExt8 = null;
        this.mExt9 = null;
        this.mSegmentCount = 0;
        this.mType = i3;
        this.mContent = str;
        this.mOId = j3;
        this.mExt1 = str2;
        this.mExt2 = str3;
        this.mExt3 = str4;
        this.mExts = bArr;
        this.mProximity = i16;
        this.mProximityStart = i17;
        this.mProximityEnd = i18;
    }

    public FTSEntity(int i3, int i16, int i17, int i18, String str, long j3, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), str, Long.valueOf(j3), str2, str3, str4, str5, str6, str7, str8, str9, str10, bArr);
            return;
        }
        this.mOpt = 0;
        this.mContentIndex = null;
        this.mSegmentCount = 0;
        this.mType = i3;
        this.mContent = str;
        this.mOId = j3;
        this.mExt1 = str2;
        this.mExt2 = str3;
        this.mExt3 = str4;
        this.mExt4 = str5;
        this.mExt5 = str6;
        this.mExt6 = str7;
        this.mExt7 = str8;
        this.mExt8 = str9;
        this.mExt9 = str10;
        this.mExts = bArr;
        this.mProximity = i16;
        this.mProximityStart = i17;
        this.mProximityEnd = i18;
    }
}

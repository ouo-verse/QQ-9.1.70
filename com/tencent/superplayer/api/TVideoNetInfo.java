package com.tencent.superplayer.api;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TVideoNetInfo implements Cloneable {
    private DefinitionInfo mCurrentDefinition;
    private ArrayList<DefinitionInfo> mDefinitionList;
    private boolean mHasWatermark = false;
    private long mUpdateTimeMillis;
    private long mVideoDurationMs;
    private long mVideoSize;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class DefinitionInfo implements Cloneable {
        private String mDefn;
        private String mDefnName;
        private String mDefnRate;
        private String mDefnShowName;

        public DefinitionInfo(String str, String str2, String str3, String str4) {
            this.mDefn = str;
            this.mDefnName = str2;
            this.mDefnRate = str3;
            this.mDefnShowName = str4;
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public String getDefn() {
            return this.mDefn;
        }

        public String getDefnName() {
            return this.mDefnName;
        }

        public String getDefnRate() {
            return this.mDefnRate;
        }

        public String getDefnShowName() {
            return this.mDefnShowName;
        }

        public void setDefn(String str) {
            this.mDefn = str;
        }

        public void setDefnName(String str) {
            this.mDefnName = str;
        }

        public void setDefnRate(String str) {
            this.mDefnRate = str;
        }

        public void setDefnShowName(String str) {
            this.mDefnShowName = str;
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public DefinitionInfo getCurrentDefinition() {
        return this.mCurrentDefinition;
    }

    public String getCurrentDefinitionStr() {
        DefinitionInfo definitionInfo = this.mCurrentDefinition;
        if (definitionInfo != null) {
            return definitionInfo.getDefn();
        }
        return "";
    }

    public ArrayList<DefinitionInfo> getDefinitionList() {
        return this.mDefinitionList;
    }

    public ArrayList<String> getDefinitionStrList() {
        if (this.mDefinitionList == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<DefinitionInfo> it = this.mDefinitionList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getDefn());
        }
        return arrayList;
    }

    public long getUpdateTimeMillis() {
        return this.mUpdateTimeMillis;
    }

    public long getVideoDuration() {
        return this.mVideoDurationMs;
    }

    public long getVideoSize() {
        return this.mVideoSize;
    }

    public boolean isHasWatermark() {
        return this.mHasWatermark;
    }

    public void setCurrentDefinition(DefinitionInfo definitionInfo) {
        this.mCurrentDefinition = definitionInfo;
    }

    public void setDefinitionList(ArrayList<DefinitionInfo> arrayList) {
        this.mDefinitionList = arrayList;
    }

    public void setHasWatermark(boolean z16) {
        this.mHasWatermark = z16;
    }

    public void setUpdateTimeMillis(long j3) {
        this.mUpdateTimeMillis = j3;
    }

    public void setVideoDuration(long j3) {
        this.mVideoDurationMs = j3;
    }

    public void setVideoSize(long j3) {
        this.mVideoSize = j3;
    }
}

package com.tencent.biz.qqcircle.beans;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchBean extends QCircleInitBean {
    private String mSearchKeyword;
    private boolean mute;
    private boolean pageInteract;
    private int mQuerySource = 3;
    private int userSource = 0;

    public boolean directlyCloseSearchPage() {
        if (this.pageInteract && !TextUtils.isEmpty(this.mSearchKeyword)) {
            return true;
        }
        return false;
    }

    public int getQuerySource() {
        return this.mQuerySource;
    }

    public String getSearchKeyword() {
        return this.mSearchKeyword;
    }

    public int getUserSource() {
        return this.userSource;
    }

    public boolean isMute() {
        return this.mute;
    }

    public boolean isPageInteract() {
        return this.pageInteract;
    }

    public void setMute(boolean z16) {
        this.mute = z16;
    }

    public void setPageInteract(boolean z16) {
        this.pageInteract = z16;
    }

    public void setQuerySource(int i3) {
        this.mQuerySource = i3;
    }

    public void setSearchKeyword(String str) {
        this.mSearchKeyword = str;
    }

    public void setUserSource(int i3) {
        this.userSource = i3;
    }
}

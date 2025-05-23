package com.tencent.libra.request;

import com.tencent.libra.listener.IPicLoadStateListener;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LibraRequestContext {
    private Option mOption;
    private IPicLoadStateListener mPicLoadStateListener;

    public LibraRequestContext(Option option, IPicLoadStateListener iPicLoadStateListener) {
        this.mOption = option;
        this.mPicLoadStateListener = iPicLoadStateListener;
    }

    public Option getOption() {
        return this.mOption;
    }

    public IPicLoadStateListener getPicLoadStateListener() {
        return this.mPicLoadStateListener;
    }

    public void setOption(Option option) {
        this.mOption = option;
    }

    public void setPicLoadStateListener(IPicLoadStateListener iPicLoadStateListener) {
        this.mPicLoadStateListener = iPicLoadStateListener;
    }
}

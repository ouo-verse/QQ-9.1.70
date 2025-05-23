package com.tencent.libra;

import com.tencent.libra.request.Option;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LoadContext {
    private final Option mOption;
    private final LibraPicLoader mPicLoader;

    public LoadContext(Option option, LibraPicLoader libraPicLoader) {
        this.mOption = option;
        this.mPicLoader = libraPicLoader;
    }

    public Option getOption() {
        return this.mOption;
    }

    public LibraPicLoader getPicLoader() {
        return this.mPicLoader;
    }
}

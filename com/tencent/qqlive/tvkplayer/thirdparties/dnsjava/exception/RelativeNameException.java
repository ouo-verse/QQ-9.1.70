package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.exception;

import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Name;

/* compiled from: P */
/* loaded from: classes23.dex */
public class RelativeNameException extends IllegalArgumentException {
    public RelativeNameException(Name name) {
        super("'" + name + "' is not an absolute name");
    }

    public RelativeNameException(String str) {
        super(str);
    }
}

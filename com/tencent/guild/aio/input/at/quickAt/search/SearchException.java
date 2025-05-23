package com.tencent.guild.aio.input.at.quickAt.search;

import uo0.k;

/* compiled from: P */
/* loaded from: classes6.dex */
public class SearchException extends Exception {
    public k context;
    public String errMsg;
    public int result;

    public SearchException(int i3, String str, k kVar) {
        super(i3 + " " + str);
        this.result = i3;
        this.errMsg = str;
        this.context = kVar;
    }
}

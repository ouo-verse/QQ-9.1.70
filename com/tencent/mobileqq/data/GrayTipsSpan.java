package com.tencent.mobileqq.data;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GrayTipsSpan implements Serializable {
    public int begin;
    public int end;
    public String url;

    public GrayTipsSpan(int i3, int i16, String str) {
        this.begin = i3;
        this.end = i16;
        this.url = str;
    }
}

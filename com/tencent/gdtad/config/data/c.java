package com.tencent.gdtad.config.data;

import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.transfile.report.ReportConstant;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class c implements IConfigData {

    @SerializedName("ext")
    public a[] ext;

    @SerializedName("switches")
    public b switches;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        public int f109148id;

        /* renamed from: s, reason: collision with root package name */
        @SerializedName(ReportConstant.COSTREPORT_PREFIX)
        public boolean[] f109149s;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class b {

        @SerializedName("switch128")
        public boolean switch128;
    }

    public String toString() {
        return l.a(this, null);
    }
}

package com.tencent.aegiskmm;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0003J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/aegiskmm/f;", "", "", "a", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes37.dex */
public interface f {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/aegiskmm/f$a;", "", "", "key", "getString", "value", "", "setString", "", "getInt", "(Ljava/lang/String;)Ljava/lang/Integer;", "setInt", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes37.dex */
    public interface a {
        Integer getInt(String key);

        String getString(String key);

        void setInt(String key, int value);

        void setString(String key, String value);
    }

    long a();
}

package com.tencent.local_edit.andserver.framework.mapping;

import androidx.annotation.NonNull;
import com.tencent.local_edit.andserver.util.MediaType;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Mime {

    /* renamed from: a, reason: collision with root package name */
    private List<Rule> f119791a = new LinkedList();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class Rule extends MediaType {
        public Rule(String str, String str2, Map<String, String> map) {
            super(str, str2, map);
        }
    }

    public void a(@NonNull String str) {
        MediaType valueOf = MediaType.valueOf(str);
        this.f119791a.add(new Rule(valueOf.getType(), valueOf.getSubtype(), valueOf.getParameters()));
    }

    @NonNull
    public List<Rule> b() {
        return this.f119791a;
    }
}

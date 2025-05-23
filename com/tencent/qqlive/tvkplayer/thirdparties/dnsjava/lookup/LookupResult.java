package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup;

import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Name;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class LookupResult {
    private final List<Name> aliases;
    private final List<Record> records;

    public LookupResult(List<Record> list, List<Name> list2) {
        List<Name> unmodifiableList;
        this.records = Collections.unmodifiableList(new ArrayList(list));
        if (list2 == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(list2));
        }
        this.aliases = unmodifiableList;
    }

    public List<Name> getAliases() {
        return this.aliases;
    }

    public List<Record> getRecords() {
        return this.records;
    }
}

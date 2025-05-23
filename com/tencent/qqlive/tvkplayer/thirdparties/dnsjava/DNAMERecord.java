package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import com.tencent.mobileqq.activity.NotificationActivity;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DNAMERecord extends SingleNameBase {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DNAMERecord() {
    }

    @Deprecated
    public Name getAlias() {
        return getName();
    }

    public Name getTarget() {
        return getSingleName();
    }

    public DNAMERecord(Name name, int i3, long j3, Name name2) {
        super(name, 39, i3, j3, name2, NotificationActivity.KEY_ALIAS);
    }
}

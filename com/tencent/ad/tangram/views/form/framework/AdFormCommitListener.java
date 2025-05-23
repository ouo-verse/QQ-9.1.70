package com.tencent.ad.tangram.views.form.framework;

import com.tencent.ad.tangram.views.form.AdFormError;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface AdFormCommitListener {
    void afterCommit(AdFormError adFormError);

    void beforeCommit();
}

package com.tencent.qzonehub.api.impl;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.tencent.qzonehub.api.IQzoneTextApi;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QzoneTextApiImpl implements IQzoneTextApi {
    @Override // com.tencent.qzonehub.api.IQzoneTextApi
    public SpannableStringBuilder createQzoneTextBuilder(String str) {
        return new com.tencent.mobileqq.qzone.api.text.a(str, 3);
    }

    @Override // com.tencent.qzonehub.api.IQzoneTextApi
    public Editable.Factory getEmoctationFacory() {
        return com.tencent.mobileqq.qzone.api.text.a.f279313d;
    }

    @Override // com.tencent.qzonehub.api.IQzoneTextApi
    public String toPlainText(Editable editable) {
        return toPlainText(editable, false);
    }

    @Override // com.tencent.qzonehub.api.IQzoneTextApi
    public String toPlainText(Editable editable, boolean z16) {
        if (editable == null) {
            return "";
        }
        if (editable instanceof com.tencent.mobileqq.qzone.api.text.a) {
            return ((com.tencent.mobileqq.qzone.api.text.a) editable).b(z16);
        }
        return editable.toString();
    }
}

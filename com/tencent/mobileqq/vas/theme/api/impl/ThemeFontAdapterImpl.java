package com.tencent.mobileqq.vas.theme.api.impl;

import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.vas.adapter.ThemeFontAdapter;
import com.tencent.mobileqq.vas.theme.api.IThemeFontAdapter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vas/theme/api/impl/ThemeFontAdapterImpl;", "Lcom/tencent/mobileqq/vas/theme/api/IThemeFontAdapter;", "()V", "switchFont", "", MessageForRichState.SIGN_MSG_FONT_ID, "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class ThemeFontAdapterImpl implements IThemeFontAdapter {
    @Override // com.tencent.mobileqq.vas.theme.api.IThemeFontAdapter
    public void switchFont(int fontId) {
        ThemeFontAdapter.B(fontId);
    }
}

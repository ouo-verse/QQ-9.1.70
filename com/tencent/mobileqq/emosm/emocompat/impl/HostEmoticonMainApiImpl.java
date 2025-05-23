package com.tencent.mobileqq.emosm.emocompat.impl;

import com.tencent.mobileqq.emosm.emocompat.IHostEmoticonMainApi;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/emosm/emocompat/impl/HostEmoticonMainApiImpl;", "Lcom/tencent/mobileqq/emosm/emocompat/IHostEmoticonMainApi;", "()V", "TAG", "", "mainPanel", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", "getMainPanel", "()Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", "setMainPanel", "(Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;)V", "getEmoticonMainApi", "onClear", "", "onInit", "emoticonPanel", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class HostEmoticonMainApiImpl implements IHostEmoticonMainApi {

    @NotNull
    private final String TAG = "HostEmoticonMainImpl";

    @Nullable
    private IEmoticonMainPanel mainPanel;

    @Override // com.tencent.mobileqq.emosm.emocompat.IHostEmoticonMainApi
    @Nullable
    /* renamed from: getEmoticonMainApi, reason: from getter */
    public IEmoticonMainPanel getMainPanel() {
        return this.mainPanel;
    }

    @Nullable
    public final IEmoticonMainPanel getMainPanel() {
        return this.mainPanel;
    }

    @Override // com.tencent.mobileqq.emosm.emocompat.IHostEmoticonMainApi
    public void onClear() {
        QLog.i(this.TAG, 4, "onClear");
        this.mainPanel = null;
    }

    @Override // com.tencent.mobileqq.emosm.emocompat.IHostEmoticonMainApi
    public void onInit(@NotNull IEmoticonMainPanel emoticonPanel) {
        Intrinsics.checkNotNullParameter(emoticonPanel, "emoticonPanel");
        QLog.i(this.TAG, 4, "onInit");
        this.mainPanel = emoticonPanel;
    }

    public final void setMainPanel(@Nullable IEmoticonMainPanel iEmoticonMainPanel) {
        this.mainPanel = iEmoticonMainPanel;
    }
}

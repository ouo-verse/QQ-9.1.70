package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.activity.lastclean.LastCleanMMKVHelper;
import com.tencent.mobileqq.filemanager.api.IFileDeleteListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/filemanager/api/impl/FileDeleteListenerImpl;", "Lcom/tencent/mobileqq/filemanager/api/IFileDeleteListener;", "", "uin", "", "requestCode", "", "onFileDelete", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FileDeleteListenerImpl implements IFileDeleteListener {

    @NotNull
    private static final String TAG = "FileDeleteListenerImpl";

    @Override // com.tencent.mobileqq.filemanager.api.IFileDeleteListener
    public void onFileDelete(@Nullable String uin, int requestCode) {
        QLog.d(TAG, 1, "onFileDelete requestCode: " + requestCode);
        if (requestCode == 1 || requestCode == 1002) {
            LastCleanMMKVHelper.f183341a.f(uin);
        }
    }
}

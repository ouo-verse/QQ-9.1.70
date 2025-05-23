package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/config/business/qfile/QFileDownloadConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/config/business/qfile/n;", "b", "", "content", "d", "newConf", "", "c", "", "version", "onSend", "<init>", "()V", "a", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class QFileDownloadConfigParser extends BaseConfigParser<n> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n defaultConfig() {
        return new n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable n newConf) {
        HashMap<String, com.tencent.mobileqq.filemanager.data.c> hashMap;
        BaseQQAppInterface A0;
        if (newConf != null) {
            hashMap = newConf.f202760d;
        } else {
            hashMap = null;
        }
        if (hashMap != null && (A0 = QQFileManagerUtilImpl.A0()) != null) {
            if (!TextUtils.isEmpty(newConf.f202761e)) {
                com.tencent.mobileqq.filemanager.util.h.h(A0, "qfile_file_auto_download", newConf.f202761e);
                QLog.i("QFileDownloadConfigParser", 1, "save download config [" + newConf.f202761e + ']');
            }
            QFileConfigManager.J(A0).C0(newConf.f202760d);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public n parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (QLog.isColorLevel()) {
            QLog.d("QFileDownloadConfigParser", 2, "parse:" + new String(content, Charsets.UTF_8));
        }
        rb1.a a16 = rb1.b.a(new String(content, Charsets.UTF_8), n.class);
        Intrinsics.checkNotNullExpressionValue(a16, "readJsonOrXml(String(con\u2026adConfigBean::class.java)");
        return (n) a16;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onSend(@NotNull String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        super.onSend(version);
        if (QLog.isColorLevel()) {
            QLog.d("QFileDownloadConfigParser", 2, "onSend:" + version);
        }
    }
}

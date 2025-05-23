package com.tencent.mobileqq.config.business.avatar;

import android.text.TextUtils;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.as;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import na1.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016J#\u0010\n\u001a\u0004\u0018\u00010\u00022\u0010\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/config/business/avatar/DynamicAvatarConfProcessor;", "Lcom/tencent/mobileqq/config/l;", "Lna1/a;", "", "type", "Ljava/lang/Class;", "clazz", "", "Lcom/tencent/mobileqq/config/ai;", "confFiles", "b", "([Lcom/tencent/mobileqq/config/ai;)Lna1/a;", "newConf", "", "c", ImageTaskConst.FAIL_CODE, "onReqFailed", "migrateOldVersion", "a", "", "isNeedCompressed", "isNeedStoreLargeFile", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class DynamicAvatarConfProcessor extends l<a> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/config/business/avatar/DynamicAvatarConfProcessor$a;", "", "Lna1/a;", "a", "", "CONFIG_ID", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final a a() {
            a aVar = (a) am.s().x(726);
            if (aVar == null) {
                return new a();
            }
            return aVar;
        }

        Companion() {
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int type) {
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a onParsed(@Nullable ai[] confFiles) {
        boolean z16;
        a.b bVar = null;
        if (confFiles != null) {
            if (confFiles.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                String content = confFiles[0].f202268b;
                if (QLog.isColorLevel()) {
                    QLog.i("DynamicAvatarConfProcessor", 2, "DynamicAvatar.[onParsed]\u00a0type=" + type() + ",\u00a0content\u00a0=\u00a0" + content);
                }
                if (!TextUtils.isEmpty(content)) {
                    try {
                        bVar = (a.b) as.e(content, a.b.class);
                    } catch (QStorageInstantiateException e16) {
                        QLog.e("DynamicAvatarConfProcessor", 1, "readJsonOrXml failed", e16);
                    }
                    Intrinsics.checkNotNullExpressionValue(content, "content");
                    return new a(content, bVar);
                }
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    @NotNull
    public Class<a> clazz() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 726;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(@Nullable a newConf) {
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int failCode) {
    }
}

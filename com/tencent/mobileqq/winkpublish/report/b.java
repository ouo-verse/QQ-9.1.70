package com.tencent.mobileqq.winkpublish.report;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/b;", "Lcom/tencent/mobileqq/winkpublish/report/WinkBaseErrorCode;", "", "getTag", "", "getErrorCodePrefix", "errorCode", "errorMsg", "<init>", "(JLjava/lang/String;)V", "d", "a", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends WinkBaseErrorCode {

    /* renamed from: e, reason: collision with root package name */
    @WinkErrorCode(msg = "\u5df2\u5728\u4e0b\u8f7d\u4e2d")
    @JvmField
    public static final long f327387e = Long.parseLong("-21000001");

    /* renamed from: f, reason: collision with root package name */
    @WinkErrorCode(msg = "\u5df2\u7ecf\u5b58\u5728")
    @JvmField
    public static final long f327388f = Long.parseLong("-21000002");

    /* renamed from: h, reason: collision with root package name */
    @WinkErrorCode(msg = "AppRuntime\u4e3a\u7a7a")
    @JvmField
    public static final long f327389h = Long.parseLong("-21000003");

    /* renamed from: i, reason: collision with root package name */
    @WinkErrorCode(msg = "\u7f51\u7edc\u8bf7\u6c42\u5f02\u5e38")
    @JvmField
    public static final long f327390i = Long.parseLong("-21000004");

    /* renamed from: m, reason: collision with root package name */
    @WinkErrorCode(msg = "MD5\u4e0d\u4e00\u81f4")
    @JvmField
    public static final long f327391m = Long.parseLong("-21000005");

    @WinkErrorCode(msg = "\u89e3\u538b\u5f02\u5e38")
    @JvmField
    public static final long C = Long.parseLong("-21000006");

    static {
        WinkBaseErrorCode.INSTANCE.loadPredefinedCode(Reflection.getOrCreateKotlinClass(b.class));
    }

    public b(long j3, @Nullable String str) {
        super(j3, str);
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    public long getErrorCodePrefix() {
        return 21L;
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    @NotNull
    public String getTag() {
        return "MediaPickerErrorCode";
    }
}

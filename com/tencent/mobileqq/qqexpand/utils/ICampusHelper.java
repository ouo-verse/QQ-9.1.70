package com.tencent.mobileqq.qqexpand.utils;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u0000 \r2\u00020\u0001:\u0001\u000eJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J.\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/utils/ICampusHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "serverSuggestSchoolName", "", "jumpToSchoolFillInWebPage", "", "idx", "schoolName", "schoolID", "jumpToSchoolCertificateWebPage", "Companion", "a", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface ICampusHelper extends QRouteApi {
    public static final int CERTIFICATE_BY_FRIEND = 1;
    public static final int CERTIFICATE_BY_STUDENTID = 2;
    public static final int CERTIFICATE_UNKNOWN = -1;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f264083a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/utils/ICampusHelper$a;", "", "<init>", "()V", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqexpand.utils.ICampusHelper$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f264083a = new Companion();

        Companion() {
        }
    }

    void jumpToSchoolCertificateWebPage(@Nullable Activity activity, int idx, @Nullable String schoolName, @Nullable String schoolID);

    void jumpToSchoolFillInWebPage(@Nullable Activity activity, @Nullable String serverSuggestSchoolName);
}
